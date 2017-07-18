package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.records.CalendarRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsCalendar;
import com.google.common.collect.ImmutableMap;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.ssullivan.mbt.gtfs.db.tables.Calendar.CALENDAR;

/**
 * Created by catal on 7/15/2017.
 */
public class ImportCalendars {
    private DSLContext _jooq;
    public ImportCalendars(DSLContext jooq) {
        _jooq = jooq;
    }

    public Long getOrCreate(final Long feedIndex, GtfsCalendar gtfsCalendar) {
        return JooqUtils.insertReturningStep(_jooq.insertInto(CALENDAR)
                .set(CALENDAR.SERVICE_ID, gtfsCalendar.id())
                .set(CALENDAR.FEED_INDEX, feedIndex)
                .set(CALENDAR.START_DATE, JooqUtils.asDate(gtfsCalendar.startDate()))
                .set(CALENDAR.END_DATE, JooqUtils.asDate(gtfsCalendar.endDate()))
                .onDuplicateKeyUpdate())
                .returning(CALENDAR.SERVICE_ID)
                .fetchOne()
                .getServiceIndex();
    }

    public ImmutableMap<String, Long> getOrCreate(final Long feedIndex, List<GtfsCalendar> gtfsCalendars) {
        return _jooq.transactionResult(configuration -> {
            final DSLContext dsl = DSL.using(configuration);

            List<InsertResultStep<CalendarRecord>> steps = gtfsCalendars
                    .stream()
                    .map(gtfsCalendar -> JooqUtils.insertReturningStep(dsl.insertInto(CALENDAR)
                            .set(CALENDAR.SERVICE_ID, gtfsCalendar.id())
                            .set(CALENDAR.FEED_INDEX, feedIndex)
                            .set(CALENDAR.START_DATE, JooqUtils.asDate(gtfsCalendar.startDate()))
                            .set(CALENDAR.END_DATE, JooqUtils.asDate(gtfsCalendar.endDate()))
                            .onDuplicateKeyIgnore())
                            .returning(CALENDAR.SERVICE_INDEX, CALENDAR.SERVICE_ID)
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
