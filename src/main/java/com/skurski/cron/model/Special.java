package com.skurski.cron.model;

/**
    string         meaning
    ------         -------
    @reboot        Run once, at startup.
    @yearly        Run once a year, "0 0 1 1 *".
    @annually      (same as @yearly)
    @monthly       Run once a month, "0 0 1 * *".
    @weekly        Run once a week, "0 0 * * 0".
    @daily         Run once a day, "0 0 * * *".
    @midnight      (same as @daily)
    @hourly        Run once an hour, "0 * * * *".
*/
public enum Special {

    REBOOT("@reboot"),
    YEARLY("@yearly"),
    ANNUALLY("@annually"),
    MONTHLY("@monthly"),
    WEEKLY("@weekly"),
    DAILY("@daily"),
    MIDNIGHT("@midnight"),
    HOURLY("@hourly");

    private String parameter;

    Special(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
