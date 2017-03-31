package com.skurski.cron.model;

import java.util.List;

/**
 * List of cron jobs in unix (crontab -l).
 */
public class Crontab {

    private List<String> content;

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public boolean isEmpty() {
        return ((content == null) || (content.isEmpty())) ? true : false;
    }

    @Override
    public String toString() {
        return "Crontab{" +
                "content='" + content + '\'' +
                '}';
    }
}
