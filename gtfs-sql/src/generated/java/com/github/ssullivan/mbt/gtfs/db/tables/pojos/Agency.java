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
public class Agency implements Serializable {

    private static final long serialVersionUID = -598475755;

    private Long   agencyIndex;
    private Long   feedIndex;
    private String agencyId;
    private String agencyName;
    private String agencyUrl;
    private String agencyTimezone;
    private String agencyLang;
    private String agencyPhone;

    public Agency() {}

    public Agency(Agency value) {
        this.agencyIndex = value.agencyIndex;
        this.feedIndex = value.feedIndex;
        this.agencyId = value.agencyId;
        this.agencyName = value.agencyName;
        this.agencyUrl = value.agencyUrl;
        this.agencyTimezone = value.agencyTimezone;
        this.agencyLang = value.agencyLang;
        this.agencyPhone = value.agencyPhone;
    }

    public Agency(
        Long   agencyIndex,
        Long   feedIndex,
        String agencyId,
        String agencyName,
        String agencyUrl,
        String agencyTimezone,
        String agencyLang,
        String agencyPhone
    ) {
        this.agencyIndex = agencyIndex;
        this.feedIndex = feedIndex;
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimezone = agencyTimezone;
        this.agencyLang = agencyLang;
        this.agencyPhone = agencyPhone;
    }

    public Long getAgencyIndex() {
        return this.agencyIndex;
    }

    public void setAgencyIndex(Long agencyIndex) {
        this.agencyIndex = agencyIndex;
    }

    public Long getFeedIndex() {
        return this.feedIndex;
    }

    public void setFeedIndex(Long feedIndex) {
        this.feedIndex = feedIndex;
    }

    public String getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
        return this.agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public String getAgencyTimezone() {
        return this.agencyTimezone;
    }

    public void setAgencyTimezone(String agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    public String getAgencyLang() {
        return this.agencyLang;
    }

    public void setAgencyLang(String agencyLang) {
        this.agencyLang = agencyLang;
    }

    public String getAgencyPhone() {
        return this.agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Agency (");

        sb.append(agencyIndex);
        sb.append(", ").append(feedIndex);
        sb.append(", ").append(agencyId);
        sb.append(", ").append(agencyName);
        sb.append(", ").append(agencyUrl);
        sb.append(", ").append(agencyTimezone);
        sb.append(", ").append(agencyLang);
        sb.append(", ").append(agencyPhone);

        sb.append(")");
        return sb.toString();
    }
}
