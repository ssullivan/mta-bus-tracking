package com.github.ssullivan.mbt.gtfs.db;

import com.github.ssullivan.mbt.gtfs.GtfsFeed;
import com.github.ssullivan.mbt.gtfs.db.tables.records.FeedsRecord;
import org.jooq.DSLContext;

import static com.github.ssullivan.mbt.gtfs.db.JooqUtils.asTimestamp;
import static com.github.ssullivan.mbt.gtfs.db.tables.Feeds.FEEDS;

/**
 * Created by catal on 7/14/2017.
 */
public class ImportFeeds {
    private DSLContext _jooq;

    public ImportFeeds(DSLContext jooq) {
        _jooq = jooq;
    }

    public long create(GtfsFeed feed) {
        FeedsRecord record = new FeedsRecord();
        record.setFeedName(feed.name());
        record.setFeedStartDate(asTimestamp(feed.startDate()));
        record.setFeedEndDate(asTimestamp(feed.endDate()));

        return _jooq.insertInto(FEEDS)
            .set(record)
            .returning(FEEDS.FEED_INDEX)
            .fetchOne()
            .getFeedIndex();
    }
}
