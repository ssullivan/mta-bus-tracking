package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.GtfsFeed;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * Created by catal on 7/17/2017.
 */
public class ImportGtfsMain {
    public static void main(String[] args) throws IOException {
        final String jdbcUrl = "jdbc:postgresql://localhost:5432/mta_gtfs";
        final String user = "postgres";
        final String password = "";

        final File file = new File(args[0]);

        final GtfsFeed gtfsFeed =
                GtfsFeed.builder()
                .name("test")
                .endDate(ZonedDateTime.now())
                .startDate(ZonedDateTime.now())
                .build();

        ImportGtfs importGtfs
         = ImportGtfs.builder()
                .jdbcUrl(jdbcUrl)
                .username(user)
                .password(password)
                .build();

        importGtfs.importGtfs(gtfsFeed, file);
    }
}
