package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.Shapes;
import com.github.ssullivan.mbt.gtfs.db.tables.Trips;
import com.github.ssullivan.mbt.gtfs.db.tables.records.TripsRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsStopTime;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsTrip;
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
public class ImportTrips {
    private DSLContext _jooq;
    private Map<String, Long> _tripIndex;
    private Map<String, Long> _serviceIndex;


    public ImportTrips(DSLContext jooq,
                       Map<String, Long> serviceIndex) {
        _jooq = jooq;
        _serviceIndex = serviceIndex;
    }

    public void importTrips(final long feedIndex, final ImmutableList<GtfsTrip> trips) {
        Lists.partition(trips, 100)
                .forEach(partition -> _jooq.transaction((configuration) -> {
                    // Lookup the ids for each shape that correspond to the trips
                    final Map<String, Long> shapeIndex =
                            getShapeIndex(feedIndex,
                                    partition
                                    .stream()
                                    .map(GtfsTrip::shapeId)
                                    .collect(Collectors.toSet()));

                    final List<TripsRecord> recordsToAdd = partition.stream()
                            .map(gtfsStopTime -> asRecord(feedIndex,
                                    shapeIndex.get(gtfsStopTime.shapeId()),
                                    gtfsStopTime))
                            .collect(Collectors.toList());


                    DSLContext dsl = DSL.using(configuration);
                    dsl.batchInsert(recordsToAdd)
                            .execute();
                }));
    }

    private Map<String, Long> getShapeIndex(final long feedIndex, Set<String> shapeIds) {
        Map<String, Long> builder = new HashMap<>();
        _jooq.select(Shapes.SHAPES.SHAPE_ID, Shapes.SHAPES.SHAPE_INDEX)
                .from(Shapes.SHAPES)
                .where(Shapes.SHAPES.FEED_INDEX.eq(feedIndex)
                        .and(Shapes.SHAPES.SHAPE_ID.in(shapeIds)))
                .forEach(shapeIndexRecord -> builder.put(shapeIndexRecord.value1(),
                        shapeIndexRecord.value2()));
        return Collections.unmodifiableMap(builder);
    }

    private Long getTripIndex(GtfsStopTime stopTime) {

        return _tripIndex.get(stopTime.tripId());
    }

    private Long getServiceIndex(GtfsTrip trip) {
        return _serviceIndex.get(trip.shapeId());
    }

    TripsRecord asRecord(final long feedIndex, final Long shapeIndex, GtfsTrip trip) {
        return new TripsRecord()
            .with(Trips.TRIPS.TRIP_ID, trip.id())
            .with(Trips.TRIPS.TRIP_HEADSIGN, trip.headSign())
            .with(Trips.TRIPS.BLOCK_ID, trip.blockId())
            .with(Trips.TRIPS.DIRECTION_ID, trip.directionId())
            .with(Trips.TRIPS.TRIP_SHORT_NAME, trip.shortName())
            .with(Trips.TRIPS.FEED_INDEX, feedIndex)
            .with(Trips.TRIPS.ROUTE_ID, trip.routeId())
            .with(Trips.TRIPS.SERVICE_INDEX, getServiceIndex(trip))
            .with(Trips.TRIPS.SHAPE_INDEX, shapeIndex);


    }
}
