/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables;


import com.github.ssullivan.mbt.gtfs.db.Keys;
import com.github.ssullivan.mbt.gtfs.db.Public;
import com.github.ssullivan.mbt.gtfs.db.tables.records.AgencyRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Agency extends TableImpl<AgencyRecord> {

    private static final long serialVersionUID = 552779980;

    /**
     * The reference instance of <code>public.agency</code>
     */
    public static final Agency AGENCY = new Agency();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AgencyRecord> getRecordType() {
        return AgencyRecord.class;
    }

    /**
     * The column <code>public.agency.agency_index</code>.
     */
    public final TableField<AgencyRecord, Long> AGENCY_INDEX = createField("agency_index", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('codegen.agency_agency_index_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.agency.feed_index</code>.
     */
    public final TableField<AgencyRecord, Long> FEED_INDEX = createField("feed_index", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.agency.agency_id</code>.
     */
    public final TableField<AgencyRecord, String> AGENCY_ID = createField("agency_id", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.agency.agency_name</code>.
     */
    public final TableField<AgencyRecord, String> AGENCY_NAME = createField("agency_name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.agency.agency_url</code>.
     */
    public final TableField<AgencyRecord, String> AGENCY_URL = createField("agency_url", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.agency.agency_timezone</code>.
     */
    public final TableField<AgencyRecord, String> AGENCY_TIMEZONE = createField("agency_timezone", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.agency.agency_lang</code>.
     */
    public final TableField<AgencyRecord, String> AGENCY_LANG = createField("agency_lang", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.agency.agency_phone</code>.
     */
    public final TableField<AgencyRecord, String> AGENCY_PHONE = createField("agency_phone", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.agency</code> table reference
     */
    public Agency() {
        this("agency", null);
    }

    /**
     * Create an aliased <code>public.agency</code> table reference
     */
    public Agency(String alias) {
        this(alias, AGENCY);
    }

    private Agency(String alias, Table<AgencyRecord> aliased) {
        this(alias, aliased, null);
    }

    private Agency(String alias, Table<AgencyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AgencyRecord, Long> getIdentity() {
        return Keys.IDENTITY_AGENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AgencyRecord> getPrimaryKey() {
        return Keys.AGENCY_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AgencyRecord>> getKeys() {
        return Arrays.<UniqueKey<AgencyRecord>>asList(Keys.AGENCY_PKEY, Keys.FEED_AGENCY_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Agency as(String alias) {
        return new Agency(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Agency rename(String name) {
        return new Agency(name, null);
    }
}