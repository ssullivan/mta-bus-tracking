/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.records;


import com.github.ssullivan.mbt.gtfs.db.tables.ServiceIndexesPerDate;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


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
public class ServiceIndexesPerDateRecord extends TableRecordImpl<ServiceIndexesPerDateRecord> implements Record3<Long, Timestamp, Long> {

    private static final long serialVersionUID = 1241053086;

    /**
     * Setter for <code>public.service_indexes_per_date.feed_index</code>.
     */
    public void setFeedIndex(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.service_indexes_per_date.feed_index</code>.
     */
    public Long getFeedIndex() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.service_indexes_per_date.date</code>.
     */
    public void setDate(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.service_indexes_per_date.date</code>.
     */
    public Timestamp getDate() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>public.service_indexes_per_date.service_index</code>.
     */
    public void setServiceIndex(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.service_indexes_per_date.service_index</code>.
     */
    public Long getServiceIndex() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Timestamp, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Timestamp, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ServiceIndexesPerDate.SERVICE_INDEXES_PER_DATE.FEED_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return ServiceIndexesPerDate.SERVICE_INDEXES_PER_DATE.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return ServiceIndexesPerDate.SERVICE_INDEXES_PER_DATE.SERVICE_INDEX;
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
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getServiceIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServiceIndexesPerDateRecord value1(Long value) {
        setFeedIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServiceIndexesPerDateRecord value2(Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServiceIndexesPerDateRecord value3(Long value) {
        setServiceIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServiceIndexesPerDateRecord values(Long value1, Timestamp value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ServiceIndexesPerDateRecord
     */
    public ServiceIndexesPerDateRecord() {
        super(ServiceIndexesPerDate.SERVICE_INDEXES_PER_DATE);
    }

    /**
     * Create a detached, initialised ServiceIndexesPerDateRecord
     */
    public ServiceIndexesPerDateRecord(Long feedIndex, Timestamp date, Long serviceIndex) {
        super(ServiceIndexesPerDate.SERVICE_INDEXES_PER_DATE);

        set(0, feedIndex);
        set(1, date);
        set(2, serviceIndex);
    }
}
