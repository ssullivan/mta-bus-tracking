/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.records;


import com.github.ssullivan.mbt.gtfs.db.tables.Agency;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
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
public class AgencyRecord extends UpdatableRecordImpl<AgencyRecord> implements Record8<Long, Long, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1772709901;

    /**
     * Setter for <code>public.agency.agency_index</code>.
     */
    public void setAgencyIndex(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.agency.agency_index</code>.
     */
    public Long getAgencyIndex() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.agency.feed_index</code>.
     */
    public void setFeedIndex(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.agency.feed_index</code>.
     */
    public Long getFeedIndex() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.agency.agency_id</code>.
     */
    public void setAgencyId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.agency.agency_id</code>.
     */
    public String getAgencyId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.agency.agency_name</code>.
     */
    public void setAgencyName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.agency.agency_name</code>.
     */
    public String getAgencyName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.agency.agency_url</code>.
     */
    public void setAgencyUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.agency.agency_url</code>.
     */
    public String getAgencyUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.agency.agency_timezone</code>.
     */
    public void setAgencyTimezone(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.agency.agency_timezone</code>.
     */
    public String getAgencyTimezone() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.agency.agency_lang</code>.
     */
    public void setAgencyLang(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.agency.agency_lang</code>.
     */
    public String getAgencyLang() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.agency.agency_phone</code>.
     */
    public void setAgencyPhone(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.agency.agency_phone</code>.
     */
    public String getAgencyPhone() {
        return (String) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, String, String, String, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, String, String, String, String, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Agency.AGENCY.AGENCY_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Agency.AGENCY.FEED_INDEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Agency.AGENCY.AGENCY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Agency.AGENCY.AGENCY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Agency.AGENCY.AGENCY_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Agency.AGENCY.AGENCY_TIMEZONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Agency.AGENCY.AGENCY_LANG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Agency.AGENCY.AGENCY_PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getAgencyIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getFeedIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAgencyId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAgencyName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getAgencyUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getAgencyTimezone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAgencyLang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getAgencyPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value1(Long value) {
        setAgencyIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value2(Long value) {
        setFeedIndex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value3(String value) {
        setAgencyId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value4(String value) {
        setAgencyName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value5(String value) {
        setAgencyUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value6(String value) {
        setAgencyTimezone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value7(String value) {
        setAgencyLang(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord value8(String value) {
        setAgencyPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AgencyRecord values(Long value1, Long value2, String value3, String value4, String value5, String value6, String value7, String value8) {
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
     * Create a detached AgencyRecord
     */
    public AgencyRecord() {
        super(Agency.AGENCY);
    }

    /**
     * Create a detached, initialised AgencyRecord
     */
    public AgencyRecord(Long agencyIndex, Long feedIndex, String agencyId, String agencyName, String agencyUrl, String agencyTimezone, String agencyLang, String agencyPhone) {
        super(Agency.AGENCY);

        set(0, agencyIndex);
        set(1, feedIndex);
        set(2, agencyId);
        set(3, agencyName);
        set(4, agencyUrl);
        set(5, agencyTimezone);
        set(6, agencyLang);
        set(7, agencyPhone);
    }
}