/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.records;


import com.github.ssullivan.mbt.gtfs.db.tables.Calendar;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
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
public class CalendarRecord extends UpdatableRecordImpl<CalendarRecord> implements Record12<Long, Long, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Date, Date> {

    private static final long serialVersionUID = -1046030439;

    /**
     * Setter for <code>public.calendar.feed_index</code>.
     */
    public void setFeedIndex(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.calendar.feed_index</code>.
     */
    public Long getFeedIndex() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.calendar.service_index</code>.
     */
    public void setServiceIndex(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.calendar.service_index</code>.
     */
    public Long getServiceIndex() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.calendar.service_id</code>.
     */
    public void setServiceId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.calendar.service_id</code>.
     */
    public String getServiceId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.calendar.monday</code>.
     */
    public void setMonday(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.calendar.monday</code>.
     */
    public Integer getMonday() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.calendar.tuesday</code>.
     */
    public void setTuesday(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.calendar.tuesday</code>.
     */
    public Integer getTuesday() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.calendar.wednesday</code>.
     */
    public void setWednesday(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.calendar.wednesday</code>.
     */
    public Integer getWednesday() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.calendar.thursday</code>.
     */
    public void setThursday(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.calendar.thursday</code>.
     */
    public Integer getThursday() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.calendar.friday</code>.
     */
    public void setFriday(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.calendar.friday</code>.
     */
    public Integer getFriday() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.calendar.saturday</code>.
     */
    public void setSaturday(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.calendar.saturday</code>.
     */
    public Integer getSaturday() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.calendar.sunday</code>.
     */
    public void setSunday(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.calendar.sunday</code>.
     */
    public Integer getSunday() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.calendar.start_date</code>.
     */
    public void setStartDate(Date value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.calendar.start_date</code>.
     */
    public Date getStartDate() {
        return (Date) get(10);
    }

    /**
     * Setter for <code>public.calendar.end_date</code>.
     */
    public void setEndDate(Date value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.calendar.end_date</code>.
     */
    public Date getEndDate() {
        return (Date) get(11);
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
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Long, Long, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Date, Date> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Long, Long, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Date, Date> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Calendar.CALENDAR.FEED_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Calendar.CALENDAR.SERVICE_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Calendar.CALENDAR.SERVICE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Calendar.CALENDAR.MONDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Calendar.CALENDAR.TUESDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Calendar.CALENDAR.WEDNESDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Calendar.CALENDAR.THURSDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Calendar.CALENDAR.FRIDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return Calendar.CALENDAR.SATURDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Calendar.CALENDAR.SUNDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field11() {
        return Calendar.CALENDAR.START_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field12() {
        return Calendar.CALENDAR.END_DATE;
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
    public Long value2() {
        return getServiceIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getServiceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getMonday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getTuesday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getWednesday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getThursday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getFriday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getSaturday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getSunday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value11() {
        return getStartDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value12() {
        return getEndDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value1(Long value) {
        setFeedIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value2(Long value) {
        setServiceIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value3(String value) {
        setServiceId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value4(Integer value) {
        setMonday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value5(Integer value) {
        setTuesday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value6(Integer value) {
        setWednesday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value7(Integer value) {
        setThursday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value8(Integer value) {
        setFriday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value9(Integer value) {
        setSaturday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value10(Integer value) {
        setSunday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value11(Date value) {
        setStartDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord value12(Date value) {
        setEndDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CalendarRecord values(Long value1, Long value2, String value3, Integer value4, Integer value5, Integer value6, Integer value7, Integer value8, Integer value9, Integer value10, Date value11, Date value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CalendarRecord
     */
    public CalendarRecord() {
        super(Calendar.CALENDAR);
    }

    /**
     * Create a detached, initialised CalendarRecord
     */
    public CalendarRecord(Long feedIndex, Long serviceIndex, String serviceId, Integer monday, Integer tuesday, Integer wednesday, Integer thursday, Integer friday, Integer saturday, Integer sunday, Date startDate, Date endDate) {
        super(Calendar.CALENDAR);

        set(0, feedIndex);
        set(1, serviceIndex);
        set(2, serviceId);
        set(3, monday);
        set(4, tuesday);
        set(5, wednesday);
        set(6, thursday);
        set(7, friday);
        set(8, saturday);
        set(9, sunday);
        set(10, startDate);
        set(11, endDate);
    }
}
