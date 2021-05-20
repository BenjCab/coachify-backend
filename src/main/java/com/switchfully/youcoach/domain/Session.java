package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.api.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;
    @ManyToOne
    @JoinColumn(name="coachee_id")
    private AccountImpl coachee;
    @ManyToOne
    @JoinColumn(name="coach_id")
    private CoachProfile coach;
    @Column(name="subject")
    private String subject;
    @Column(name="location")
    private String location;
    @Column(name="remarks")
    private String remarks;
    @Column(name="session_date")
    private LocalDate date;
    @Column(name="session_time")
    private LocalTime time;

    public Session(long sessionId, AccountImpl coachee, CoachProfile coach, String subject, String location, String remarks, LocalDate date, LocalTime time) {
        this.sessionId = sessionId;
        this.coachee = coachee;
        this.coach = coach;
        this.subject = subject;
        this.location = location;
        this.remarks = remarks;
        this.date = date;
        this.time = time;
    }

    public Session() {
    }

    public long getSessionId() {
        return sessionId;
    }

    public Session setSessionId(long sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public AccountImpl getCoachee() {
        return coachee;
    }

    public Session setCoachee(AccountImpl coachee) {
        this.coachee = coachee;
        return this;
    }

    public CoachProfile getCoach() {
        return coach;
    }

    public Session setCoach(CoachProfile coach) {
        this.coach = coach;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Session setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Session setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Session setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Session setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public Session setTime(LocalTime time) {
        this.time = time;
        return this;
    }
}
