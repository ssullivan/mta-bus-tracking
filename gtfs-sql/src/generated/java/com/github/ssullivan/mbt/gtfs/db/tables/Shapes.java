/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables;


import com.github.ssullivan.mbt.gtfs.db.Keys;
import com.github.ssullivan.mbt.gtfs.db.Public;
import com.github.ssullivan.mbt.gtfs.db.tables.records.ShapesRecord;

import java.math.BigDecimal;
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
public class Shapes extends TableImpl<ShapesRecord> {

    private static final long serialVersionUID = 163039561;

    /**
     * The reference instance of <code>public.shapes</code>
     */
    public static final Shapes SHAPES = new Shapes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ShapesRecord> getRecordType() {
        return ShapesRecord.class;
    }

    /**
     * The column <code>public.shapes.feed_index</code>.
     */
    public final TableField<ShapesRecord, Long> FEED_INDEX = createField("feed_index", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.shapes.shape_index</code>.
     */
    public final TableField<ShapesRecord, Long> SHAPE_INDEX = createField("shape_index", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('codegen.shapes_shape_index_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.shapes.shape_id</code>.
     */
    public final TableField<ShapesRecord, String> SHAPE_ID = createField("shape_id", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.shapes.shape_pt_lat</code>.
     */
    public final TableField<ShapesRecord, Double> SHAPE_PT_LAT = createField("shape_pt_lat", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.shapes.shape_pt_lon</code>.
     */
    public final TableField<ShapesRecord, Double> SHAPE_PT_LON = createField("shape_pt_lon", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.shapes.shape_pt_sequence</code>.
     */
    public final TableField<ShapesRecord, Integer> SHAPE_PT_SEQUENCE = createField("shape_pt_sequence", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.shapes.shape_dist_traveled</code>.
     */
    public final TableField<ShapesRecord, BigDecimal> SHAPE_DIST_TRAVELED = createField("shape_dist_traveled", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * Create a <code>public.shapes</code> table reference
     */
    public Shapes() {
        this("shapes", null);
    }

    /**
     * Create an aliased <code>public.shapes</code> table reference
     */
    public Shapes(String alias) {
        this(alias, SHAPES);
    }

    private Shapes(String alias, Table<ShapesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Shapes(String alias, Table<ShapesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ShapesRecord, Long> getIdentity() {
        return Keys.IDENTITY_SHAPES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ShapesRecord> getPrimaryKey() {
        return Keys.SHAPES_PRIMARY_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ShapesRecord>> getKeys() {
        return Arrays.<UniqueKey<ShapesRecord>>asList(Keys.SHAPES_PRIMARY_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Shapes as(String alias) {
        return new Shapes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Shapes rename(String name) {
        return new Shapes(name, null);
    }
}
