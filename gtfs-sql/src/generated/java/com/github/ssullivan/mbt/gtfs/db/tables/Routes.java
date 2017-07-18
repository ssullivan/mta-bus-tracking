/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables;


import com.github.ssullivan.mbt.gtfs.db.Keys;
import com.github.ssullivan.mbt.gtfs.db.Public;
import com.github.ssullivan.mbt.gtfs.db.tables.records.RoutesRecord;

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
public class Routes extends TableImpl<RoutesRecord> {

    private static final long serialVersionUID = -1697487782;

    /**
     * The reference instance of <code>public.routes</code>
     */
    public static final Routes ROUTES = new Routes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoutesRecord> getRecordType() {
        return RoutesRecord.class;
    }

    /**
     * The column <code>public.routes.feed_index</code>.
     */
    public final TableField<RoutesRecord, Long> FEED_INDEX = createField("feed_index", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.routes.route_index</code>.
     */
    public final TableField<RoutesRecord, Long> ROUTE_INDEX = createField("route_index", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('codegen.routes_route_index_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.routes.route_id</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_ID = createField("route_id", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.routes.agency_index</code>.
     */
    public final TableField<RoutesRecord, Long> AGENCY_INDEX = createField("agency_index", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.routes.route_short_name</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_SHORT_NAME = createField("route_short_name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.routes.route_long_name</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_LONG_NAME = createField("route_long_name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.routes.route_desc</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_DESC = createField("route_desc", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.routes.route_type</code>.
     */
    public final TableField<RoutesRecord, Integer> ROUTE_TYPE = createField("route_type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.routes.route_url</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_URL = createField("route_url", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.routes.route_color</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_COLOR = createField("route_color", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.routes.route_text_color</code>.
     */
    public final TableField<RoutesRecord, String> ROUTE_TEXT_COLOR = createField("route_text_color", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.routes</code> table reference
     */
    public Routes() {
        this("routes", null);
    }

    /**
     * Create an aliased <code>public.routes</code> table reference
     */
    public Routes(String alias) {
        this(alias, ROUTES);
    }

    private Routes(String alias, Table<RoutesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Routes(String alias, Table<RoutesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<RoutesRecord, Long> getIdentity() {
        return Keys.IDENTITY_ROUTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RoutesRecord> getPrimaryKey() {
        return Keys.ROUTES_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RoutesRecord>> getKeys() {
        return Arrays.<UniqueKey<RoutesRecord>>asList(Keys.FEED_ROUTE_UNIQUE, Keys.ROUTES_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Routes as(String alias) {
        return new Routes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Routes rename(String name) {
        return new Routes(name, null);
    }
}
