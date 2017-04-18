package com.skurski.cron.model;


/**
 * ExpertCron job intervals.
 * todo: configure parameter for every enum
 */
public enum Interval {
    MINUTE_1("* * * * *", "minute"),
    MINUTE_2("* * * * *", "2 minutes"),
    MINUTE_3("* * * * *", "3 minutes"),
    MINUTE_4("* * * * *", "4 minutes"),
    MINUTE_5("* * * * *", "5 minutes"),
    MINUTE_10("* * * * *", "10 minutes"),
    MINUTE_15("* * * * *", "15 minutes"),
    MINUTE_20("* * * * *", "20 minutes"),
    MINUTE_30("* * * * *", "30 minutes"),
    HOUR_1("* * * * *", "hour"),
    HOUR_2("* * * * *", "2 hours"),
    HOUR_3("* * * * *", "3 hours"),
    HOUR_4("* * * * *", "4 hours"),
    HOUR_6("* * * * *", "6 hours"),
    HOUR_8("* * * * *", "8 hours"),
    HOUR_12("* * * * *", "12 hours"),
    DAY_1("* * * * *", "day"),
    DAY_2("* * * * *", "2 days"),
    DAY_3("* * * * *", "3 days"),
    DAY_5("* * * * *", "5 days"),
    DAY_10("* * * * *", "10 days"),
    DAY_15("* * * * *", "15 days"),
    WEEK_1("* * * * *", "week"),
    WEEK_2("* * * * *", "2 weeks"),
    MONTH("* * * * *", "month");

    private String parameter;
    private String desc;

    Interval(String parameter, String desc) {
        this.parameter = parameter;
        this.desc = desc;
    }

    public String getParameter() {
        return parameter;
    }

    public String getDesc() {
        return desc;
    }
}
