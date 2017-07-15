package com.github.ssullivan.mbt.gtfs.db;

import org.jooq.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public final class JooqUtils {
    public static Timestamp asTimestamp(final ZonedDateTime zonedDateTime) {
        return new Timestamp(zonedDateTime.toEpochSecond() * 1000);
    }

    public static Date asDate(final ZonedDateTime zonedDateTime) {
        return new Date(zonedDateTime.toEpochSecond() * 1000);
    }

    public static Date asDate(final LocalDate localDate) {
        return new Date(localDate.toEpochDay());
    }

    public static <R extends Record> InsertReturningStep<R> insertReturningStep(InsertOnDuplicateSetStep<R> onDuplicateSetStep) {
        InsertReturningStep<R> query =
                (InsertReturningStep<R>)  onDuplicateSetStep;
        return query;
    }


    public static <R extends Record> InsertReturningStep<R> insertReturningStep(InsertOnDuplicateStep<R> onDuplicateSetStep) {
        InsertReturningStep<R> query =
                (InsertReturningStep<R>)  onDuplicateSetStep;
        return query;
    }

    public static <R extends Record> InsertReturningStep<R> insertReturningStep(InsertFinalStep<R> onDuplicateSetStep) {
        InsertReturningStep<R> query =
                (InsertReturningStep<R>)  onDuplicateSetStep;
        return query;
    }


    private static Long toSeconds(final String hms) {
        if (hms == null) return -1L;
        String parts[] = hms.trim().split("\\:", 3);

        if (parts.length != 3) {
            return -1L;
        }
        /**
         * GTFS represents arrival, and departures times potentially as values greater than 24hours
         *
         * GTFS times are typically offset from Noon minus 12 hours
         *
         * (Hour * 3600) + (Minute * 60) + Seconds
         */
        return Long.valueOf(parts[0]) * 3600 + Integer.valueOf(parts[1]) * 60 + Integer.valueOf(parts[2]);
    }

}
