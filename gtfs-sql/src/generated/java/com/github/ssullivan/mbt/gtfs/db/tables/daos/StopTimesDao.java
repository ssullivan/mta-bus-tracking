/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.daos;


import com.github.ssullivan.mbt.gtfs.db.tables.StopTimes;
import com.github.ssullivan.mbt.gtfs.db.tables.records.StopTimesRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StopTimesDao extends DAOImpl<StopTimesRecord, com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes, Record2<Long, Integer>> {

    /**
     * Create a new StopTimesDao without any configuration
     */
    public StopTimesDao() {
        super(StopTimes.STOP_TIMES, com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes.class);
    }

    /**
     * Create a new StopTimesDao with an attached configuration
     */
    public StopTimesDao(Configuration configuration) {
        super(StopTimes.STOP_TIMES, com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Record2<Long, Integer> getId(com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes object) {
        return compositeKeyRecord(object.getTripIndex(), object.getStopSequence());
    }

    /**
     * Fetch records that have <code>trip_index IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByTripIndex(Long... values) {
        return fetch(StopTimes.STOP_TIMES.TRIP_INDEX, values);
    }

    /**
     * Fetch records that have <code>arrival_time IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByArrivalTime(String... values) {
        return fetch(StopTimes.STOP_TIMES.ARRIVAL_TIME, values);
    }

    /**
     * Fetch records that have <code>departure_time IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByDepartureTime(String... values) {
        return fetch(StopTimes.STOP_TIMES.DEPARTURE_TIME, values);
    }

    /**
     * Fetch records that have <code>arrival_time_seconds IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByArrivalTimeSeconds(Long... values) {
        return fetch(StopTimes.STOP_TIMES.ARRIVAL_TIME_SECONDS, values);
    }

    /**
     * Fetch records that have <code>departure_time_seconds IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByDepartureTimeSeconds(Long... values) {
        return fetch(StopTimes.STOP_TIMES.DEPARTURE_TIME_SECONDS, values);
    }

    /**
     * Fetch records that have <code>stop_id IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByStopId(Integer... values) {
        return fetch(StopTimes.STOP_TIMES.STOP_ID, values);
    }

    /**
     * Fetch records that have <code>stop_sequence IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByStopSequence(Integer... values) {
        return fetch(StopTimes.STOP_TIMES.STOP_SEQUENCE, values);
    }

    /**
     * Fetch records that have <code>stop_headsign IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByStopHeadsign(String... values) {
        return fetch(StopTimes.STOP_TIMES.STOP_HEADSIGN, values);
    }

    /**
     * Fetch records that have <code>pickup_type IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByPickupType(String... values) {
        return fetch(StopTimes.STOP_TIMES.PICKUP_TYPE, values);
    }

    /**
     * Fetch records that have <code>drop_off_type IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.StopTimes> fetchByDropOffType(String... values) {
        return fetch(StopTimes.STOP_TIMES.DROP_OFF_TYPE, values);
    }
}
