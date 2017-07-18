/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.daos;


import com.github.ssullivan.mbt.gtfs.db.tables.Stops;
import com.github.ssullivan.mbt.gtfs.db.tables.records.StopsRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
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
public class StopsDao extends DAOImpl<StopsRecord, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops, Long> {

    /**
     * Create a new StopsDao without any configuration
     */
    public StopsDao() {
        super(Stops.STOPS, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops.class);
    }

    /**
     * Create a new StopsDao with an attached configuration
     */
    public StopsDao(Configuration configuration) {
        super(Stops.STOPS, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops object) {
        return object.getStopIndex();
    }

    /**
     * Fetch records that have <code>feed_index IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByFeedIndex(Long... values) {
        return fetch(Stops.STOPS.FEED_INDEX, values);
    }

    /**
     * Fetch records that have <code>stop_index IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopIndex(Long... values) {
        return fetch(Stops.STOPS.STOP_INDEX, values);
    }

    /**
     * Fetch a unique record that has <code>stop_index = value</code>
     */
    public com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops fetchOneByStopIndex(Long value) {
        return fetchOne(Stops.STOPS.STOP_INDEX, value);
    }

    /**
     * Fetch records that have <code>stop_id IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopId(Integer... values) {
        return fetch(Stops.STOPS.STOP_ID, values);
    }

    /**
     * Fetch records that have <code>stop_code IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopCode(String... values) {
        return fetch(Stops.STOPS.STOP_CODE, values);
    }

    /**
     * Fetch records that have <code>stop_name IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopName(String... values) {
        return fetch(Stops.STOPS.STOP_NAME, values);
    }

    /**
     * Fetch records that have <code>stop_desc IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopDesc(String... values) {
        return fetch(Stops.STOPS.STOP_DESC, values);
    }

    /**
     * Fetch records that have <code>stop_lat IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopLat(Double... values) {
        return fetch(Stops.STOPS.STOP_LAT, values);
    }

    /**
     * Fetch records that have <code>stop_lon IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopLon(Double... values) {
        return fetch(Stops.STOPS.STOP_LON, values);
    }

    /**
     * Fetch records that have <code>zone_id IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByZoneId(Integer... values) {
        return fetch(Stops.STOPS.ZONE_ID, values);
    }

    /**
     * Fetch records that have <code>stop_url IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByStopUrl(String... values) {
        return fetch(Stops.STOPS.STOP_URL, values);
    }

    /**
     * Fetch records that have <code>location_type IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByLocationType(Integer... values) {
        return fetch(Stops.STOPS.LOCATION_TYPE, values);
    }

    /**
     * Fetch records that have <code>parent_station IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Stops> fetchByParentStation(Integer... values) {
        return fetch(Stops.STOPS.PARENT_STATION, values);
    }
}
