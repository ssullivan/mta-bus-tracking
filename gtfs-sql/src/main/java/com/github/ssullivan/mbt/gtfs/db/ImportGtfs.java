package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.GtfsData;
import com.github.ssullivan.mbt.gtfs.GtfsFeed;
import com.github.ssullivan.mbt.gtfs.GtfsReader;
import com.google.common.collect.ImmutableMap;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.*;

/**
 * Created by catal on 7/14/2017.
 */
public class ImportGtfs implements Closeable {
    private String _username;
    private String _password;
    private String _jdbcUrl;
    private DSLContext _jooq;
    private ImportFeeds _feedRepo;

    public void importGtfs(final GtfsFeed feed, final File file) throws IOException {
        try (FileInputStream fin = new FileInputStream(file)) {
            importGtfs(feed, fin);
        }
    }

    public void importGtfs(final GtfsFeed feed, final InputStream inputStream) throws IOException {
        GtfsReader gtfsReader = new GtfsReader();
        GtfsData gtfsData = gtfsReader.read(inputStream);

        setupDatabaseConnection();

        // Add the Feed to the feeds table
        final long feedIndex = _feedRepo.create(feed);

        final ImmutableMap<String, Long> agencyIndex =
                new ImportAgencies(_jooq).getOrCreate(feedIndex, gtfsData.agencies());

        final ImmutableMap<String, Long> serviceIndex =
                new ImportCalendars(_jooq)
                        .getOrCreate(feedIndex, gtfsData.calendars());

        new ImportCalendarDates(_jooq, serviceIndex)
                .getOrCreate(feedIndex, gtfsData.calendarDates());

        new ImportRoutes(_jooq, agencyIndex)
                .importRoutes(feedIndex, gtfsData.routes());

        new ImportShapePoints(_jooq)
                .importShapePoints(feedIndex, gtfsData.shapePoints());

        new ImportTrips(_jooq, serviceIndex)
                .importTrips(feedIndex, gtfsData.trips());

        new ImportStopTimes(_jooq)
                .importStopTimes(feedIndex, gtfsData.stopTimes());

        new ImportStops(_jooq, serviceIndex)
                .importStops(feedIndex, gtfsData.stops());

    }

    public static Builder builder() {
        return new Builder();
    }

    private void setupDatabaseConnection() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(_jdbcUrl);
        config.setUsername(_username);
        config.setPassword(_password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);

       _jooq = DSL.using(ds, SQLDialect.POSTGRES);

       _feedRepo = new ImportFeeds(_jooq);
    }

    @Override
    public void close() throws IOException {
        if (null != _jooq)
            _jooq.close();
    }

    public static class Builder {
        private ImportGtfs _importGtfs = new ImportGtfs();
        private Builder() {

        }

        public Builder username(String username) {
            _importGtfs._username = username;
            return this;
        }

        public Builder password(String password) {
            _importGtfs._password = password;
            return this;
        }

        public Builder jdbcUrl(String jdbcUrl) {
            _importGtfs._jdbcUrl = jdbcUrl;
            return this;
        }

        public ImportGtfs build() {
            return _importGtfs;
        }
    }
}
