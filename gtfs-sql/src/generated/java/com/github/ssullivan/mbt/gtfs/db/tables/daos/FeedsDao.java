/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.daos;


import com.github.ssullivan.mbt.gtfs.db.tables.Feeds;
import com.github.ssullivan.mbt.gtfs.db.tables.records.FeedsRecord;

import java.sql.Timestamp;
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
public class FeedsDao extends DAOImpl<FeedsRecord, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds, Long> {

    /**
     * Create a new FeedsDao without any configuration
     */
    public FeedsDao() {
        super(Feeds.FEEDS, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds.class);
    }

    /**
     * Create a new FeedsDao with an attached configuration
     */
    public FeedsDao(Configuration configuration) {
        super(Feeds.FEEDS, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds object) {
        return object.getFeedIndex();
    }

    /**
     * Fetch records that have <code>feed_index IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds> fetchByFeedIndex(Long... values) {
        return fetch(Feeds.FEEDS.FEED_INDEX, values);
    }

    /**
     * Fetch a unique record that has <code>feed_index = value</code>
     */
    public com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds fetchOneByFeedIndex(Long value) {
        return fetchOne(Feeds.FEEDS.FEED_INDEX, value);
    }

    /**
     * Fetch records that have <code>feed_start_date IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds> fetchByFeedStartDate(Timestamp... values) {
        return fetch(Feeds.FEEDS.FEED_START_DATE, values);
    }

    /**
     * Fetch records that have <code>feed_end_date IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds> fetchByFeedEndDate(Timestamp... values) {
        return fetch(Feeds.FEEDS.FEED_END_DATE, values);
    }

    /**
     * Fetch records that have <code>feed_name IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Feeds> fetchByFeedName(String... values) {
        return fetch(Feeds.FEEDS.FEED_NAME, values);
    }
}