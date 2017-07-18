/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.records;


import com.github.ssullivan.mbt.gtfs.db.tables.Adherence;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class AdherenceRecord extends UpdatableRecordImpl<AdherenceRecord> implements Record8<Timestamp, Byte, String, Byte, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -332856392;

    /**
     * Setter for <code>public.adherence.date</code>.
     */
    public void setDate(Timestamp value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.adherence.date</code>.
     */
    public Timestamp getDate() {
        return (Timestamp) get(0);
    }

    /**
     * Setter for <code>public.adherence.hour</code>.
     */
    public void setHour(Byte value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.adherence.hour</code>.
     */
    public Byte getHour() {
        return (Byte) get(1);
    }

    /**
     * Setter for <code>public.adherence.route_id</code>.
     */
    public void setRouteId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.adherence.route_id</code>.
     */
    public String getRouteId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.adherence.direction_id</code>.
     */
    public void setDirectionId(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.adherence.direction_id</code>.
     */
    public Byte getDirectionId() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>public.adherence.stop_id</code>.
     */
    public void setStopId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.adherence.stop_id</code>.
     */
    public Integer getStopId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.adherence.early</code>.
     */
    public void setEarly(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.adherence.early</code>.
     */
    public Integer getEarly() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.adherence.on_time</code>.
     */
    public void setOnTime(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.adherence.on_time</code>.
     */
    public Integer getOnTime() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.adherence.late</code>.
     */
    public void setLate(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.adherence.late</code>.
     */
    public Integer getLate() {
        return (Integer) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record5<Timestamp, Byte, String, Byte, Integer> key() {
        return (Record5) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Timestamp, Byte, String, Byte, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Timestamp, Byte, String, Byte, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field1() {
        return Adherence.ADHERENCE.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field2() {
        return Adherence.ADHERENCE.HOUR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Adherence.ADHERENCE.ROUTE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Adherence.ADHERENCE.DIRECTION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Adherence.ADHERENCE.STOP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Adherence.ADHERENCE.EARLY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Adherence.ADHERENCE.ON_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Adherence.ADHERENCE.LATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value1() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value2() {
        return getHour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getRouteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getDirectionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getStopId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getEarly();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getOnTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getLate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value1(Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value2(Byte value) {
        setHour(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value3(String value) {
        setRouteId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value4(Byte value) {
        setDirectionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value5(Integer value) {
        setStopId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value6(Integer value) {
        setEarly(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value7(Integer value) {
        setOnTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord value8(Integer value) {
        setLate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdherenceRecord values(Timestamp value1, Byte value2, String value3, Byte value4, Integer value5, Integer value6, Integer value7, Integer value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AdherenceRecord
     */
    public AdherenceRecord() {
        super(Adherence.ADHERENCE);
    }

    /**
     * Create a detached, initialised AdherenceRecord
     */
    public AdherenceRecord(Timestamp date, Byte hour, String routeId, Byte directionId, Integer stopId, Integer early, Integer onTime, Integer late) {
        super(Adherence.ADHERENCE);

        set(0, date);
        set(1, hour);
        set(2, routeId);
        set(3, directionId);
        set(4, stopId);
        set(5, early);
        set(6, onTime);
        set(7, late);
    }
}
