package com.switchfully.youcoach.api.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public class SessionDTO {
    private long sessionId;
    private long coacheeId;
    private long coachId;
    private String subject;
    private String location;
    private String remarks;
    private LocalDate date;
    private LocalTime time;

    public SessionDTO() {
    }

    public long getCoacheeId() {
        return coacheeId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public SessionDTO setSessionId(long sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public SessionDTO setCoacheeId(long coacheeId) {
        this.coacheeId = coacheeId;
        return this;
    }

    public long getCoachId() {
        return coachId;
    }

    public SessionDTO setCoachId(long coachId) {
        this.coachId = coachId;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public SessionDTO setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public SessionDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public SessionDTO setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public SessionDTO setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public SessionDTO setTime(LocalTime time) {
        this.time = time;
        return this;
    }
}
