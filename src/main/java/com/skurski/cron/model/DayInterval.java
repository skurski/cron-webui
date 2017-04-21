package com.skurski.cron.model;


public enum DayInterval {

    DAY_1("day") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " * * *";
        }
    },
    DAY_2("2 days") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " */2 * *";
        }
    },
    DAY_3("3 days") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " */3 * *";
        }
    },
    DAY_5("5 days") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " */5 * *";
        }
    },
    DAY_7("7 days") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " */7 * *";
        }
    },
    DAY_10("10 days") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " */10 * *";
        }
    },
    DAY_15("15 days") {
        @Override
        public String getParameter() {
            return super.getMinute() + " " + super.getHour() + " */15 * *";
        }
    };

    private String desc;
    private String minute;
    private String hour;
    private String parameter;

    DayInterval(String desc) {
        this.desc = desc;
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

    public abstract String getParameter();

    public String getDesc() {
        return desc;
    }
}
