package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.validations.ValidationUtil;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;
    @ManyToOne
    @JoinColumn(name = "coachee_id")
    private AccountImpl coachee;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private CoachProfile coach;
    @Column(name = "subject")
    private String subject;
    @Column(name = "location")
    private String location;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "session_date")
    private LocalDate date;
    @Column(name = "session_time")
    private LocalTime time;
    @Column(name = "status")
    private String status;
    @OneToOne
    @JoinColumn(name = "feedback_coachee_id")
    private SessionFeedbackCoachee sessionFeedbackCoachee;
    @OneToOne
    @JoinColumn(name = "feedback_coach_id")
    private SessionFeedbackCoach sessionFeedbackCoach;

    public Session(long sessionId, AccountImpl coachee, CoachProfile coach, String subject, String location, String remarks, LocalDate date, LocalTime time, SessionFeedbackCoachee sessionFeedbackCoachee, SessionFeedbackCoach sessionFeedbackCoach) {
        this.sessionId = sessionId;
        this.coachee = coachee;
        this.coach = coach;
        this.subject = subject;
        this.location = location;
        this.remarks = remarks;
        this.date = date;
        this.time = time;
        this.sessionFeedbackCoachee = sessionFeedbackCoachee;
        this.sessionFeedbackCoach = sessionFeedbackCoach;
    }

    public SessionFeedbackCoachee getSessionFeedbackCoachee() {
        return sessionFeedbackCoachee;
    }

    public Session setSessionFeedbackCoachee(SessionFeedbackCoachee sessionFeedbackCoachee) {
        this.sessionFeedbackCoachee = sessionFeedbackCoachee;
        return this;
    }

    public Session() {
    }

    public SessionFeedbackCoach getSessionFeedbackCoach() {
        return sessionFeedbackCoach;
    }

    public Session setSessionFeedbackCoach(SessionFeedbackCoach sessionFeedbackCoach) {
        this.sessionFeedbackCoach = sessionFeedbackCoach;
        return this;
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
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(coach, "Coach");
        this.coach = coach;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Session setSubject(String subject) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(subject, "Subject");
        this.subject = subject;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Session setLocation(String location) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(location, "Location");
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
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(date, "Date");
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public Session setTime(LocalTime time) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(time, "Time");
        this.time = time;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Session setStatus(String status) {
        this.status = validateSessionStatus(status);
        return this;
    }

    public String validateSessionStatus(String sessionStatus) {
        switch (sessionStatus.toLowerCase(Locale.ROOT)) {
            case "requested":
                return "Requested";
            case "accepted":
                return "Accepted";
            case "done, waiting feedback":
                return "Done, waiting feedback";
            case "finished (feedback provided)":
                return "Finished (feedback provided)";
            case "finished (cancelled by coachee)":
                return "Finished (cancelled by coachee)";
            case "finished (cancelled by coach)":
                return "Finished (cancelled by coach)";
            case "finished (declined)":
                return "Finished (declined)";
            case "finished (automatically closed)":
                return "Finished (automatically closed)";
            default:
                throw new IllegalArgumentException("Status of session does not exist.");
        }
    }
}
