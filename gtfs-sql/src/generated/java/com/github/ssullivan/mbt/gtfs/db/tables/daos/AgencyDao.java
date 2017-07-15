/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.daos;


import com.github.ssullivan.mbt.gtfs.db.tables.Agency;
import com.github.ssullivan.mbt.gtfs.db.tables.records.AgencyRecord;

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
public class AgencyDao extends DAOImpl<AgencyRecord, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency, Long> {

    /**
     * Create a new AgencyDao without any configuration
     */
    public AgencyDao() {
        super(Agency.AGENCY, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency.class);
    }

    /**
     * Create a new AgencyDao with an attached configuration
     */
    public AgencyDao(Configuration configuration) {
        super(Agency.AGENCY, com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency object) {
        return object.getAgencyIndex();
    }

    /**
     * Fetch records that have <code>agency_index IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyIndex(Long... values) {
        return fetch(Agency.AGENCY.AGENCY_INDEX, values);
    }

    /**
     * Fetch a unique record that has <code>agency_index = value</code>
     */
    public com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency fetchOneByAgencyIndex(Long value) {
        return fetchOne(Agency.AGENCY.AGENCY_INDEX, value);
    }

    /**
     * Fetch records that have <code>feed_index IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByFeedIndex(Long... values) {
        return fetch(Agency.AGENCY.FEED_INDEX, values);
    }

    /**
     * Fetch records that have <code>agency_id IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyId(String... values) {
        return fetch(Agency.AGENCY.AGENCY_ID, values);
    }

    /**
     * Fetch records that have <code>agency_name IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyName(String... values) {
        return fetch(Agency.AGENCY.AGENCY_NAME, values);
    }

    /**
     * Fetch records that have <code>agency_url IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyUrl(String... values) {
        return fetch(Agency.AGENCY.AGENCY_URL, values);
    }

    /**
     * Fetch records that have <code>agency_timezone IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyTimezone(String... values) {
        return fetch(Agency.AGENCY.AGENCY_TIMEZONE, values);
    }

    /**
     * Fetch records that have <code>agency_lang IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyLang(String... values) {
        return fetch(Agency.AGENCY.AGENCY_LANG, values);
    }

    /**
     * Fetch records that have <code>agency_phone IN (values)</code>
     */
    public List<com.github.ssullivan.mbt.gtfs.db.tables.pojos.Agency> fetchByAgencyPhone(String... values) {
        return fetch(Agency.AGENCY.AGENCY_PHONE, values);
    }
}
