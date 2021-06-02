package com.switchfully.youcoach.api.DTOs;

public class SessionFeedbackCoacheeDTO {
    private Long sessionFeedbackCoacheeId;
    private Long sessionId;
    private int explanationRating;
    private int usefulRating;
    private String comment1;
    private String comment2;

    public SessionFeedbackCoacheeDTO(Long sessionFeedbackCoacheeId, Long sessionId, int explanationRating, int usefulRating, String comment1, String comment2) {
        this.sessionFeedbackCoacheeId = sessionFeedbackCoacheeId;
        this.sessionId = sessionId;
        this.explanationRating = explanationRating;
        this.usefulRating = usefulRating;
        this.comment1 = comment1;
        this.comment2 = comment2;
    }

    public Long getSessionFeedbackCoacheeId() {
        return sessionFeedbackCoacheeId;
    }

    public SessionFeedbackCoacheeDTO setSessionFeedbackCoacheeId(Long sessionFeedbackCoacheeId) {
        this.sessionFeedbackCoacheeId = sessionFeedbackCoacheeId;
        return this;
    }

    public SessionFeedbackCoacheeDTO() {
    }

    public Long getSessionId() {
        return sessionId;
    }

    public SessionFeedbackCoacheeDTO setSessionId(Long sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public int getExplanationRating() {
        return explanationRating;
    }

    public SessionFeedbackCoacheeDTO setExplanationRating(int explanationRating) {
        this.explanationRating = explanationRating;
        return this;
    }

    public int getUsefulRating() {
        return usefulRating;
    }

    public SessionFeedbackCoacheeDTO setUsefulRating(int usefulRating) {
        this.usefulRating = usefulRating;
        return this;
    }

    public String getComment1() {
        return comment1;
    }

    public SessionFeedbackCoacheeDTO setComment1(String comment1) {
        this.comment1 = comment1;
        return this;
    }

    public String getComment2() {
        return comment2;
    }

    public SessionFeedbackCoacheeDTO setComment2(String comment2) {
        this.comment2 = comment2;
        return this;
    }
}
