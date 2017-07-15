package com.github.ssullivan.mbt.gtfs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.ssullivan.mbt.gtfs.models.csv.*;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by catal on 7/8/2017.
 */
public class GtfsReader {
    private static final Logger Log = LoggerFactory.getLogger(GtfsReader.class);
    private static ObjectMapper MAPPER = new CsvMapper();

    private static final String AGENCY_CSV = "agency.txt";
    private static final String CALENDAR_CSV = "calendar.txt";
    private static final String CALENDAR_DATES_CSV = "calendar_dates.txt";
    private static final String ROUTES_CSV = "routes.txt";
    private static final String SHAPES_CSV = "shapes.txt";
    private static final String STOP_TIMES_CSV = "stop_times.txt";
    private static final String STOPS_CSV = "stops.txt";
    private static final String TRIPS_CSV = "trips.txt";


    public GtfsData read(InputStream inputStream) throws IOException {
        GtfsData.Builder builder = GtfsData.builder();

        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, Charset.forName("UTF-8"))) {

            ZipEntry zipEntry = null;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                switch (zipEntry.getName()) {
                    case AGENCY_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.agenciesBuilder(), GtfsAgency.class);
                        break;
                    case CALENDAR_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.calendarsBuilder(), GtfsCalendar.class);
                        break;
                    case CALENDAR_DATES_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.calendarDatesBuilder(), GtfsCalendarDate.class);
                        break;
                    case ROUTES_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.routesBuilder(), GtfsRoute.class);
                        break;
                    case SHAPES_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.shapePointsBuilder(), GtfsShapePoint.class);
                        break;
                    case STOPS_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.stopsBuilder(), GtfsStop.class);
                        break;
                    case STOP_TIMES_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.stopTimesBuilder(), GtfsStopTime.class);
                        break;
                    case TRIPS_CSV:
                        readCsv(new ClosedShieldInputStream(zipInputStream), builder.tripsBuilder(), GtfsTrip.class);
                        break;
                    default:
                        Log.warn("Unrecognized GTFS file {}", zipEntry.getName());
                        zipInputStream.closeEntry();
                }
                zipInputStream.closeEntry();
            }
        }
        return builder.build();
    }

    private <T> void readCsv(InputStream inputStream, ImmutableList.Builder<T> builder, Class<T> clazz) throws IOException {
        CsvSchema schema = CsvSchema
                .builder()
                .setUseHeader(true)
                .build();

        Iterator<T> iter = MAPPER.readerFor(clazz)
                .with(schema)
                .readValues(inputStream);

        while (iter.hasNext()) {
            T next = iter.next();
            builder.add(next);
        }
    }


    private static class ClosedShieldInputStream extends InputStream {
        private InputStream _delegate;

        public ClosedShieldInputStream(InputStream delegate) {
            _delegate = delegate;
        }

        @Override
        public int read() throws IOException {
            return _delegate.read();
        }

        @Override
        public int read(byte[] b) throws IOException {
            return _delegate.read(b);
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return _delegate.read(b, off, len);
        }

        @Override
        public long skip(long n) throws IOException {
            return _delegate.skip(n);
        }

        @Override
        public int available() throws IOException {
            return _delegate.available();
        }

        @Override
        public synchronized void mark(int readlimit) {
            _delegate.mark(readlimit);
        }

        @Override
        public synchronized void reset() throws IOException {
            _delegate.reset();
        }

        @Override
        public boolean markSupported() {
            return _delegate.markSupported();
        }

        @Override
        public void close() throws IOException {

        }
    }
}
