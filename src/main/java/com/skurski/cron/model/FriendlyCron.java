package com.skurski.cron.model;

import java.util.Optional;

/**
 * User friendly cron object.
 *
 */
public class FriendlyCron {

    private String script = "";

    private Optional<Interval> interval = Optional.empty();

    private Optional<DayInterval> dayInterval = Optional.empty();

    private FriendlyOption option;

    private Optional<String> hourWeekly = Optional.empty();

    private Optional<String> hourDaily = Optional.empty();

    private Optional<String> hourMonthly = Optional.empty();

    private Optional<String> dayOfWeek = Optional.empty();

    private Optional<String> dayOfMonth = Optional.empty();

    public FriendlyCron() {}

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Optional<Interval> getInterval() {
        return interval;
    }

    public void setInterval(Optional<Interval> interval) {
        this.interval = interval;
    }

    public FriendlyOption getOption() {
        return option;
    }

    public void setOption(FriendlyOption option) {
        this.option = option;
    }

    public Optional<String> getHourWeekly() {
        return hourWeekly;
    }

    public void setHourWeekly(Optional<String> hourWeekly) {
        this.hourWeekly = hourWeekly;
    }

    public Optional<String> getHourDaily() {
        return hourDaily;
    }

    public void setHourDaily(Optional<String> hourDaily) {
        this.hourDaily = hourDaily;
    }

    public boolean isEmpty() {
        return script.isEmpty();
    }

    public Optional<DayInterval> getDayInterval() {
        return dayInterval;
    }

    public void setDayInterval(Optional<DayInterval> dayInterval) {
        this.dayInterval = dayInterval;
    }

    public Optional<String> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Optional<String> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Optional<String> getHourMonthly() {
        return hourMonthly;
    }

    public void setHourMonthly(Optional<String> hourMonthly) {
        this.hourMonthly = hourMonthly;
    }

    public Optional<String> getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Optional<String> dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getCommand() {
        if (option == FriendlyOption.INTERVAL_HOURLY && interval.isPresent()) {
            return interval.get().getParameter() + " " + script;
        }
        if (option == FriendlyOption.HOUR_DAILY && dayInterval.isPresent()) {
            String[] time = hourDaily.get().split(":");
            dayInterval.get().setHour(time[0]);
            dayInterval.get().setMinute(time[1]);
            return dayInterval.get().getParameter() + " " + script;
        }
        if (option == FriendlyOption.TIME_AND_DAY_WEEKLY && hourWeekly.isPresent()) {
            String[] time = hourWeekly.get().split(":");
            return time[1] + " " + time[0] + " *" + " * " + dayOfWeek.get() + " " + script;
        }
        if (option == FriendlyOption.TIME_AND_DATE_MONTHLY && hourMonthly.isPresent()) {
            String[] time = hourMonthly.get().split(":");
            return time[1] + " " + time[0] + " " + dayOfMonth.get() + " * * " + script;
        }
        return "";
    }

    @Override
    public String toString() {
        return "FriendlyCron{" +
                "script='" + script + '\'' +
                ", interval=" + interval +
                ", dayInterval=" + dayInterval +
                ", option=" + option +
                ", hourWeekly=" + hourWeekly +
                ", hourDaily=" + hourDaily +
                ", hourMonthly=" + hourMonthly +
                ", dayOfWeek=" + dayOfWeek +
                ", dayOfMonth=" + dayOfMonth +
                '}';
    }
}
