package com.skurski.cron.model;

import java.util.Optional;

/**
    # Minute   Hour   Day of Month       Month          Day of Week
    # (0-59)  (0-23)     (1-31)         (1-12)            (0-6)
*/
public class Cron {

    private String script = "";

    private Optional<Special> special = Optional.empty();

    private String minute = "*";
    private String hour = "*";
    private String dayOfMonth = "*";
    private String month = "*";
    private String dayOfWeek = "*";

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Optional<Special> getSpecial() {
        return special;
    }

    public void setSpecial(Optional<Special> special) {
        this.special = special;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getParamsWithScript() {
        return minute + " " + hour + " " + dayOfMonth + " " + month + " " + dayOfWeek + " " + script;
    }

    public boolean isSpecial() {
        return special.isPresent();
    }

    public boolean isEmpty() {
        return script.isEmpty();
    }

    public String getSpecialWithScript() {
        return special.get().getParameter() + " " + script;
    }

    @Override
    public String toString() {
        return "Cron{" +
                "script='" + script + '\'' +
                ", special=" + special +
                ", minute=" + minute +
                ", hour=" + hour +
                ", dayOfMonth=" + dayOfMonth +
                ", month=" + month +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
