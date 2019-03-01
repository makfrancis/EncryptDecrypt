package com.francis.example.attendanceSummary;

import java.time.LocalTime;

public class Account {

    private String eid;
    private LocalTime date;
    private Boolean isOnTime;

    public Account(String eid, LocalTime date, Boolean isOnTime) {
        this.eid = eid;
        this.date = date;
        this.isOnTime = isOnTime;
    }

    public Account(String eid, LocalTime date) {
        this.eid = eid;
        this.date = date;
    }

    public String getEid() {
        return eid;
    }

    public LocalTime getDate() {
        return date;
    }

    public Boolean getOnTime() {
        return isOnTime;
    }
}
