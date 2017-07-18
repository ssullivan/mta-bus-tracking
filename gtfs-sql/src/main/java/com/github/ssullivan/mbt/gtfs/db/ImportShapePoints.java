package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.Shapes;
import com.github.ssullivan.mbt.gtfs.db.tables.records.RoutesRecord;
import com.github.ssullivan.mbt.gtfs.db.tables.records.ShapesRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsShapePoint;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by catal on 7/15/2017.
 */
public class ImportShapePoints {
    private DSLContext _jooq;


    public ImportShapePoints(DSLContext jooq) {
        _jooq = jooq;
    }

    public void importShapePoints(final long feedIndex, final ImmutableList<GtfsShapePoint> shapePoints) {
        RoutesRecord routesRecord = new RoutesRecord();

        Lists.partition(shapePoints, 100)
                .forEach(partition -> {
                    final List<ShapesRecord> recordsToAdd = partition.stream()
                            .map(gtfsShapePoint -> asRecord(feedIndex, gtfsShapePoint))
                            .collect(Collectors.toList());

                    _jooq.transaction((configuration) -> {
                        DSLContext dsl = DSL.using(configuration);
                        dsl.batchInsert(recordsToAdd)
                                .execute();
                    });
                });
    }

    ShapesRecord asRecord(final long feedIndex, GtfsShapePoint gtfsShapePoint) {
        return new ShapesRecord()
                .with(Shapes.SHAPES.SHAPE_ID, gtfsShapePoint.id())
                .with(Shapes.SHAPES.FEED_INDEX, feedIndex)
                .with(Shapes.SHAPES.SHAPE_DIST_TRAVELED, null != gtfsShapePoint.distanceTraveled() ?
                        BigDecimal.valueOf(gtfsShapePoint.distanceTraveled()) : null)
                .with(Shapes.SHAPES.SHAPE_PT_LAT, gtfsShapePoint.lat())
                .with(Shapes.SHAPES.SHAPE_PT_LAT, gtfsShapePoint.lon())
                .with(Shapes.SHAPES.SHAPE_PT_SEQUENCE, gtfsShapePoint.sequence());

    }
}
