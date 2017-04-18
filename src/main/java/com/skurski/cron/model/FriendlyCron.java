package com.skurski.cron.model;

import java.util.Optional;

/**
 * User friendly cron object.
 */
public class FriendlyCron {

    private String script = "";

    private Optional<Interval> interval = Optional.empty();

    private FriendlyOption option;

    private Optional<String> hour = Optional.empty();

    private Optional<HourOccurence> occurence = Optional.empty();

    private Optional<String> dateTime = Optional.empty();

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

    public Optional<String> getHour() {
        return hour;
    }

    public void setHour(Optional<String> hour) {
        this.hour = hour;
    }

    public boolean isEmpty() {
        return script.isEmpty();
    }

    public Optional<HourOccurence> getOccurence() {
        return occurence;
    }

    public void setOccurence(Optional<HourOccurence> occurence) {
        this.occurence = occurence;
    }

    public Optional<String> getDateTime() {
        return dateTime;
    }

    public void setDateTime(Optional<String> dateTime) {
        this.dateTime = dateTime;
    }

    public String getCommand() {
        if (option == FriendlyOption.INTERVAL) {
            return interval.get().getParameter() + " " + script;
        }
        if (option == FriendlyOption.HOUR) {
            return "";
        }
        // FriendlyOption.DATE_TIME
        return "";
    }

    @Override
    public String toString() {
        return "FriendlyCron{" +
                "script='" + script + '\'' +
                ", interval=" + interval +
                ", option=" + option +
                '}';
    }
}
