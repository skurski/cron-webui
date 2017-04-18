package com.skurski.cron.model;

/**
 * Settings for friendly cron HOUR option.
 */
public enum HourOccurence {
    ONCE("only once"),
    EVERY_DAY("every day"),
    EVERY_WEEK("every week"),
    EVERY_MONTH("every month");

    private String desc;

    HourOccurence(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
