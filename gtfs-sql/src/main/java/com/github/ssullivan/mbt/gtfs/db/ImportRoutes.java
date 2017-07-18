package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.Routes;
import com.github.ssullivan.mbt.gtfs.db.tables.records.RoutesRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsRoute;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by catal on 7/15/2017.
 */
public class ImportRoutes {
    private DSLContext _jooq;
    private Map<String, Long> _agencyIndex;

    public ImportRoutes(DSLContext jooq, Map<String, Long> agencyIndex) {
        _jooq = jooq;
        _agencyIndex = agencyIndex;
    }

    public void importRoutes(final long feedIndex, final ImmutableList<GtfsRoute> routes) {
        RoutesRecord routesRecord = new RoutesRecord();

        Lists.partition(routes, 100)
                .forEach(partition -> {
                    final List<RoutesRecord> recordsToAdd = partition.stream()
                            .map(gtfsRoute -> asRecord(feedIndex, gtfsRoute))
                            .collect(Collectors.toList());

                   _jooq.transaction((configuration) -> {
                       DSLContext dsl = DSL.using(configuration);
                       dsl.batchInsert(recordsToAdd)
                               .execute();
                   });
                });
    }

    RoutesRecord asRecord(final long feedIndex, GtfsRoute gtfsRoute) {
        return new RoutesRecord()
            .with(Routes.ROUTES.AGENCY_INDEX, _agencyIndex.get(gtfsRoute.agencyId()))
            .with(Routes.ROUTES.FEED_INDEX, feedIndex)
            .with(Routes.ROUTES.ROUTE_ID, gtfsRoute.id())
            .with(Routes.ROUTES.ROUTE_COLOR, gtfsRoute.color())
            .with(Routes.ROUTES.ROUTE_TEXT_COLOR, gtfsRoute.textColor())
            .with(Routes.ROUTES.ROUTE_DESC, gtfsRoute.description())
            .with(Routes.ROUTES.ROUTE_LONG_NAME, gtfsRoute.longName())
            .with(Routes.ROUTES.ROUTE_SHORT_NAME, gtfsRoute.shortName())
            .with(Routes.ROUTES.ROUTE_TYPE, gtfsRoute.type())
            .with(Routes.ROUTES.ROUTE_URL, gtfsRoute.url());
    }
}
