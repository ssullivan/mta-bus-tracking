package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.StopTimes;
import com.github.ssullivan.mbt.gtfs.db.tables.Trips;
import com.github.ssullivan.mbt.gtfs.db.tables.records.StopTimesRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsStopTime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by catal on 7/15/2017.
 */
public class ImportStopTimes {
    private DSLContext _jooq;

    public ImportStopTimes(DSLContext jooq) {
        _jooq = jooq;
    }

    public void importStopTimes(final long feedIndex, final ImmutableList<GtfsStopTime> stopTimes) {
        Lists.partition(stopTimes, 100)
                .forEach(partition -> {
                    _jooq.transaction((configuration) -> {
                        final Map<String, Long> tripIndex = getTripIndex(feedIndex,
                                partition
                                .stream()
                                .map(GtfsStopTime::tripId)
                                .collect(Collectors.toSet()));

                        final List<StopTimesRecord> recordsToAdd = partition.stream()
                                .map(gtfsStopTime -> asRecord(feedIndex,
                                        tripIndex.get(gtfsStopTime.tripId()),
                                        gtfsStopTime))
                                .collect(Collectors.toList());


                        DSLContext dsl = DSL.using(configuration);
                        dsl.batchInsert(recordsToAdd)
                                .execute();
                    });
                });
    }

    private Map<String, Long> getTripIndex(final long feedIndex,
                                           Set<String> tripIds) {
        Map<String, Long> builder = new HashMap<>();
        _jooq.select(Trips.TRIPS.TRIP_ID, Trips.TRIPS.TRIP_INDEX)
                .from(Trips.TRIPS)
                .where(Trips.TRIPS.FEED_INDEX.eq(feedIndex)
                        .and(Trips.TRIPS.TRIP_ID.in(tripIds)))
                .forEach(resultRecord -> builder.put(resultRecord.value1(),
                        resultRecord.value2()));
        return Collections.unmodifiableMap(builder);
    }


    StopTimesRecord asRecord(final long feedIndex, final Long tripId, GtfsStopTime stopTime) {
        return new StopTimesRecord()
            .with(StopTimes.STOP_TIMES.STOP_ID, stopTime.stopId())
            .with(StopTimes.STOP_TIMES.STOP_HEADSIGN, stopTime.stopHeadSign())
            .with(StopTimes.STOP_TIMES.STOP_SEQUENCE, stopTime.stopSequence())
            .with(StopTimes.STOP_TIMES.ARRIVAL_TIME, stopTime.arrivalTime())
            .with(StopTimes.STOP_TIMES.DEPARTURE_TIME, stopTime.departureTime())
            .with(StopTimes.STOP_TIMES.ARRIVAL_TIME_SECONDS, stopTime.arrivalTimeSeconds())
            .with(StopTimes.STOP_TIMES.DEPARTURE_TIME_SECONDS, stopTime.departueTimeSeconds())
            .with(StopTimes.STOP_TIMES.DROP_OFF_TYPE, stopTime.dropoffType())
            .with(StopTimes.STOP_TIMES.PICKUP_TYPE, stopTime.pickupType())
            .with(StopTimes.STOP_TIMES.TRIP_INDEX, tripId);

    }
}
