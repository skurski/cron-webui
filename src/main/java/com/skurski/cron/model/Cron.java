package com.skurski.cron.model;

import java.util.Optional;

/**
    # Minute   Hour   Day of Month       Month          Day of Week
    # (0-59)  (0-23)     (1-31)         (1-12)            (0-6)
*/
public class Cron {

    private String script;

    private Optional<Special> special;

    private int minute;
    private int hour;
    private int dayOfMonth;
    private int month;
    private int dayOfWeek;

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

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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
