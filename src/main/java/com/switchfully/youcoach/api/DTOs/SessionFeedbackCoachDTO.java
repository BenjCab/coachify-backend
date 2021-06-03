package com.switchfully.youcoach.api.DTOs;

public class SessionFeedbackCoachDTO {
    private Long sessionFeedbackCoachId;
    private Long sessionId;
    private int rating1;
    private int rating2;
    private String comment1;
    private String comment2;

    public SessionFeedbackCoachDTO() {
    }

    public Long getSessionFeedbackCoachId() {
        return sessionFeedbackCoachId;
    }

    public SessionFeedbackCoachDTO setSessionFeedbackCoachId(Long sessionFeedbackCoachId) {
        this.sessionFeedbackCoachId = sessionFeedbackCoachId;
        return this;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public SessionFeedbackCoachDTO setSessionId(Long sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public int getRating1() {
        return rating1;
    }

    public SessionFeedbackCoachDTO setRating1(int rating1) {
        this.rating1 = rating1;
        return this;
    }

    public int getRating2() {
        return rating2;
    }

    public SessionFeedbackCoachDTO setRating2(int rating2) {
        this.rating2 = rating2;
        return this;
    }

    public String getComment1() {
        return comment1;
    }

    public SessionFeedbackCoachDTO setComment1(String comment1) {
        this.comment1 = comment1;
        return this;
    }

    public String getComment2() {
        return comment2;
    }

    public SessionFeedbackCoachDTO setComment2(String comment2) {
        this.comment2 = comment2;
        return this;
    }
}
