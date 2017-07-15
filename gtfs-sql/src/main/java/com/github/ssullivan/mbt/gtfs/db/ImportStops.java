package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.Stops;
import com.github.ssullivan.mbt.gtfs.db.tables.records.StopsRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsStop;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by catal on 7/15/2017.
 */
public class ImportStops {
    private DSLContext _jooq;
    private Map<String, Long> _tripIndex;
    private Map<String, Long> _serviceIndex;


    public ImportStops(DSLContext jooq,
                       Map<String, Long> serviceIndex) {
        _jooq = jooq;
        _serviceIndex = serviceIndex;
    }

    public void importStops(final long feedIndex, final ImmutableList<GtfsStop> stops) {
        Lists.partition(stops, 100)
                .forEach(partition -> _jooq.transaction((configuration) -> {
                    final List<StopsRecord> recordsToAdd = partition.stream()
                            .map(gtfsStop -> asRecord(feedIndex,
                                    gtfsStop))
                            .collect(Collectors.toList());


                    DSLContext dsl = DSL.using(configuration);
                    dsl.batchInsert(recordsToAdd)
                            .execute();
                }));
    }


    StopsRecord asRecord(final long feedIndex, GtfsStop stop) {
        return new StopsRecord()
                .with(Stops.STOPS.STOP_CODE, stop.code())
                .with(Stops.STOPS.STOP_DESC, stop.description())
                .with(Stops.STOPS.STOP_ID, stop.id())
                .with(Stops.STOPS.FEED_INDEX, feedIndex)
                .with(Stops.STOPS.LOCATION_TYPE, stop.locationType())
                .with(Stops.STOPS.PARENT_STATION, stop.parentStation())
                .with(Stops.STOPS.STOP_LAT, stop.lat())
                .with(Stops.STOPS.STOP_LON, stop.lon())
                .with(Stops.STOPS.STOP_NAME, stop.name())
                .with(Stops.STOPS.STOP_URL, stop.url())
                .with(Stops.STOPS.ZONE_ID, stop.zoneId());


    }
}
