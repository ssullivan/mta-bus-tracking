package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.records.CalendarDatesRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsCalendarDate;
import com.google.common.collect.ImmutableMap;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.github.ssullivan.mbt.gtfs.db.tables.CalendarDates.CALENDAR_DATES;

/**
 * Created by catal on 7/15/2017.
 */
public class ImportCalendarDates {
    private DSLContext _jooq;
    private Map<String, Long> _serviceIndex;

    public ImportCalendarDates(DSLContext jooq, Map<String, Long> serviceIndex) {
        _jooq = jooq;
        _serviceIndex = serviceIndex;
    }

    public Long getOrCreate(final Long feedIndex, GtfsCalendarDate gtfsCalendarDate) {
        return JooqUtils.insertReturningStep(_jooq.insertInto(CALENDAR_DATES)
                .set(CALENDAR_DATES.SERVICE_ID, gtfsCalendarDate.id())
                .set(CALENDAR_DATES.FEED_INDEX, feedIndex)
                .set(CALENDAR_DATES.SERVICE_INDEX, _serviceIndex.get(gtfsCalendarDate.id()))
                .set(CALENDAR_DATES.EXCEPTION_DATE, JooqUtils.asDate(gtfsCalendarDate.date()))
                .onDuplicateKeyIgnore())
                .returning(CALENDAR_DATES.SERVICE_INDEX)
                .fetchOne()
                .getServiceIndex();
    }

    public ImmutableMap<String, Long> getOrCreate(final Long feedIndex, List<GtfsCalendarDate> gtfsCalendarDates) {
        return _jooq.transactionResult(configuration -> {
            final DSLContext dsl = DSL.using(configuration);

            List<InsertResultStep<CalendarDatesRecord>> steps = gtfsCalendarDates
                    .stream()
                    .map(record -> JooqUtils.insertReturningStep(dsl.insertInto(CALENDAR_DATES)
                            .set(CALENDAR_DATES.SERVICE_ID, record.id())
                            .set(CALENDAR_DATES.FEED_INDEX, feedIndex)
                            .set(CALENDAR_DATES.SERVICE_INDEX, _serviceIndex.get(record.id()))
                            .set(CALENDAR_DATES.EXCEPTION_DATE, JooqUtils.asDate(record.date()))
                            .onDuplicateKeyIgnore())
                            .returning(CALENDAR_DATES.SERVICE_INDEX, CALENDAR_DATES.SERVICE_ID)
                    ).collect(Collectors.toList());

            ImmutableMap.Builder<String, Long> builder = new ImmutableMap.Builder<>();
            steps.stream()
                    .map(InsertResultStep::fetchOne)
                    .forEach(record -> builder
                            .put(record.getServiceId(), record.getServiceIndex()));

            return builder.build();
        });
    }
}
