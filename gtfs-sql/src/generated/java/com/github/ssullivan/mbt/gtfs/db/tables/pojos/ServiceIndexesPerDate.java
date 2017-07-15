/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class ServiceIndexesPerDate implements Serializable {

    private static final long serialVersionUID = -591582493;

    private Long      feedIndex;
    private Timestamp date;
    private Long      serviceIndex;

    public ServiceIndexesPerDate() {}

    public ServiceIndexesPerDate(ServiceIndexesPerDate value) {
        this.feedIndex = value.feedIndex;
        this.date = value.date;
        this.serviceIndex = value.serviceIndex;
    }

    public ServiceIndexesPerDate(
        Long      feedIndex,
        Timestamp date,
        Long      serviceIndex
    ) {
        this.feedIndex = feedIndex;
        this.date = date;
        this.serviceIndex = serviceIndex;
    }

    public Long getFeedIndex() {
        return this.feedIndex;
    }

    public void setFeedIndex(Long feedIndex) {
        this.feedIndex = feedIndex;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getServiceIndex() {
        return this.serviceIndex;
    }

    public void setServiceIndex(Long serviceIndex) {
        this.serviceIndex = serviceIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ServiceIndexesPerDate (");

        sb.append(feedIndex);
        sb.append(", ").append(date);
        sb.append(", ").append(serviceIndex);

        sb.append(")");
        return sb.toString();
    }
}
