package com.skurski.cron.model;

/**
 * List of cron jobs in unix (crontab -l).
 */
public class Crontab {

    private String content;

    public Crontab(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Crontab{" +
                "content='" + content + '\'' +
                '}';
    }
}
