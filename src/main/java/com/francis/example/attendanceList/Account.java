package com.francis.example.attendanceList;

import java.time.LocalDateTime;

public class Account {

    private String eid;
    private LocalDateTime now;

    public Account(String eid, LocalDateTime now) {
        this.eid = eid;
        this.now = now;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }
}
