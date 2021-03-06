/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.records;


import com.github.ssullivan.mbt.gtfs.db.tables.Feeds;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class FeedsRecord extends UpdatableRecordImpl<FeedsRecord> implements Record4<Long, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = -854112543;

    /**
     * Setter for <code>public.feeds.feed_index</code>.
     */
    public void setFeedIndex(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.feeds.feed_index</code>.
     */
    public Long getFeedIndex() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.feeds.feed_start_date</code>.
     */
    public void setFeedStartDate(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.feeds.feed_start_date</code>.
     */
    public Timestamp getFeedStartDate() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>public.feeds.feed_end_date</code>.
     */
    public void setFeedEndDate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.feeds.feed_end_date</code>.
     */
    public Timestamp getFeedEndDate() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>public.feeds.feed_name</code>.
     */
    public void setFeedName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.feeds.feed_name</code>.
     */
    public String getFeedName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Timestamp, Timestamp, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, Timestamp, Timestamp, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Feeds.FEEDS.FEED_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Feeds.FEEDS.FEED_START_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Feeds.FEEDS.FEED_END_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Feeds.FEEDS.FEED_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getFeedIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getFeedStartDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getFeedEndDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getFeedName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedsRecord value1(Long value) {
        setFeedIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedsRecord value2(Timestamp value) {
        setFeedStartDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedsRecord value3(Timestamp value) {
        setFeedEndDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedsRecord value4(String value) {
        setFeedName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedsRecord values(Long value1, Timestamp value2, Timestamp value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FeedsRecord
     */
    public FeedsRecord() {
        super(Feeds.FEEDS);
    }

    /**
     * Create a detached, initialised FeedsRecord
     */
    public FeedsRecord(Long feedIndex, Timestamp feedStartDate, Timestamp feedEndDate, String feedName) {
        super(Feeds.FEEDS);

        set(0, feedIndex);
        set(1, feedStartDate);
        set(2, feedEndDate);
        set(3, feedName);
    }
}
