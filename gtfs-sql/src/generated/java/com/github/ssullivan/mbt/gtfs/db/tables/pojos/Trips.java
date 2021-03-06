/*
 * This file is generated by jOOQ.
*/
package com.github.ssullivan.mbt.gtfs.db.tables.pojos;


import java.io.Serializable;

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
public class Trips implements Serializable {

    private static final long serialVersionUID = 640586553;

    private Long    feedIndex;
    private Long    tripIndex;
    private Integer routeId;
    private Long    serviceIndex;
    private String  tripId;
    private String  tripHeadsign;
    private String  tripShortName;
    private Integer directionId;
    private Integer blockId;
    private Long    shapeIndex;

    public Trips() {}

    public Trips(Trips value) {
        this.feedIndex = value.feedIndex;
        this.tripIndex = value.tripIndex;
        this.routeId = value.routeId;
        this.serviceIndex = value.serviceIndex;
        this.tripId = value.tripId;
        this.tripHeadsign = value.tripHeadsign;
        this.tripShortName = value.tripShortName;
        this.directionId = value.directionId;
        this.blockId = value.blockId;
        this.shapeIndex = value.shapeIndex;
    }

    public Trips(
        Long    feedIndex,
        Long    tripIndex,
        Integer routeId,
        Long    serviceIndex,
        String  tripId,
        String  tripHeadsign,
        String  tripShortName,
        Integer directionId,
        Integer blockId,
        Long    shapeIndex
    ) {
        this.feedIndex = feedIndex;
        this.tripIndex = tripIndex;
        this.routeId = routeId;
        this.serviceIndex = serviceIndex;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
        this.tripShortName = tripShortName;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeIndex = shapeIndex;
    }

    public Long getFeedIndex() {
        return this.feedIndex;
    }

    public void setFeedIndex(Long feedIndex) {
        this.feedIndex = feedIndex;
    }

    public Long getTripIndex() {
        return this.tripIndex;
    }

    public void setTripIndex(Long tripIndex) {
        this.tripIndex = tripIndex;
    }

    public Integer getRouteId() {
        return this.routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Long getServiceIndex() {
        return this.serviceIndex;
    }

    public void setServiceIndex(Long serviceIndex) {
        this.serviceIndex = serviceIndex;
    }

    public String getTripId() {
        return this.tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripHeadsign() {
        return this.tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public String getTripShortName() {
        return this.tripShortName;
    }

    public void setTripShortName(String tripShortName) {
        this.tripShortName = tripShortName;
    }

    public Integer getDirectionId() {
        return this.directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public Integer getBlockId() {
        return this.blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Long getShapeIndex() {
        return this.shapeIndex;
    }

    public void setShapeIndex(Long shapeIndex) {
        this.shapeIndex = shapeIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Trips (");

        sb.append(feedIndex);
        sb.append(", ").append(tripIndex);
        sb.append(", ").append(routeId);
        sb.append(", ").append(serviceIndex);
        sb.append(", ").append(tripId);
        sb.append(", ").append(tripHeadsign);
        sb.append(", ").append(tripShortName);
        sb.append(", ").append(directionId);
        sb.append(", ").append(blockId);
        sb.append(", ").append(shapeIndex);

        sb.append(")");
        return sb.toString();
    }
}
