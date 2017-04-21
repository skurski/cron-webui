package com.skurski.cron.model;


/**
 * ExpertCron job intervals.
 *
 *  # Minute   Hour   Day of Month       Month          Day of Week
 *  # (0-59)  (0-23)     (1-31)         (1-12)            (0-6)
 */
public enum Interval {
    MINUTE_1("* * * * *", "minute"),
    MINUTE_2("*/2 * * * *", "2 minutes"),
    MINUTE_3("*/3 * * * *", "3 minutes"),
    MINUTE_4("*/4 * * * *", "4 minutes"),
    MINUTE_5("*/5 * * * *", "5 minutes"),
    MINUTE_10("*/10 * * * *", "10 minutes"),
    MINUTE_15("*/15 * * * *", "15 minutes"),
    MINUTE_20("*/20 * * * *", "20 minutes"),
    MINUTE_30("*/30 * * * *", "30 minutes"),
    HOUR_1("0 * * * *", "hour"),
    HOUR_2("0 */2 * * *", "2 hours"),
    HOUR_3("0 */3 * * *", "3 hours"),
    HOUR_4("0 */4 * * *", "4 hours"),
    HOUR_6("0 */6 * * *", "6 hours"),
    HOUR_8("0 */8 * * *", "8 hours"),
    HOUR_12("0 */12 * * *", "12 hours");

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
