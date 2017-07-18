package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.db.tables.records.AgencyRecord;
import com.github.ssullivan.mbt.gtfs.models.csv.GtfsAgency;
import com.google.common.collect.ImmutableMap;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.ssullivan.mbt.gtfs.db.tables.Agency.AGENCY;

/**
 * Created by catal on 7/14/2017.
 */
public class ImportAgencies {
    private DSLContext _jooq;

    public ImportAgencies(DSLContext jooq) {
        _jooq = jooq;
    }

    public Long getOrCreate(final Long feedIndex, GtfsAgency gtfsAgency) {
        return JooqUtils.insertReturningStep(_jooq.insertInto(AGENCY)
                .set(AGENCY.AGENCY_ID, gtfsAgency.id())
                .set(AGENCY.FEED_INDEX, feedIndex)
                .set(AGENCY.AGENCY_LANG, gtfsAgency.lang())
                .set(AGENCY.AGENCY_NAME, gtfsAgency.name())
                .set(AGENCY.AGENCY_PHONE, gtfsAgency.phoneNumber())
                .set(AGENCY.AGENCY_TIMEZONE, gtfsAgency.timeZone())
                .set(AGENCY.AGENCY_URL, gtfsAgency.url())
                .onDuplicateKeyUpdate())
                .returning(AGENCY.AGENCY_INDEX)
                .fetchOne()
                .getAgencyIndex();
    }

    public ImmutableMap<String, Long> getOrCreate(final Long feedIndex, List<GtfsAgency> gtfsAgencies) {
        return _jooq.transactionResult(configuration -> {
            final DSLContext dsl = DSL.using(configuration);

            List<InsertResultStep<AgencyRecord>> steps = gtfsAgencies
                    .stream()
                    .map(gtfsAgency -> JooqUtils.insertReturningStep(dsl.insertInto(AGENCY)
                            .set(AGENCY.AGENCY_ID, gtfsAgency.id())
                            .set(AGENCY.FEED_INDEX, feedIndex)
                            .set(AGENCY.AGENCY_LANG, gtfsAgency.lang())
                            .set(AGENCY.AGENCY_NAME, gtfsAgency.name())
                            .set(AGENCY.AGENCY_PHONE, gtfsAgency.phoneNumber())
                            .set(AGENCY.AGENCY_TIMEZONE, gtfsAgency.timeZone())
                            .set(AGENCY.AGENCY_URL, gtfsAgency.url())
                            .onDuplicateKeyIgnore())
                            .returning(AGENCY.AGENCY_INDEX, AGENCY.AGENCY_ID)
                    ).collect(Collectors.toList());

            ImmutableMap.Builder<String, Long> builder = new ImmutableMap.Builder<>();
            steps.stream()
                    .map(InsertResultStep::fetchOne)
                    .forEach(agencyRecord -> builder
                            .put(agencyRecord.getAgencyId(), agencyRecord.getAgencyIndex()));

            return builder.build();
        });
    }
}
