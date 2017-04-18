package com.skurski.cron.model;

public class CronDto {

    private int id;

    private String row;

    private static int counter = 0;

    public CronDto() {}

    public CronDto(String row) {
        this.id = counter++;
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }
}
