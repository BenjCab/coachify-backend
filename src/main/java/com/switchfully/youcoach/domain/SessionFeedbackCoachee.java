package com.switchfully.youcoach.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback_coachee")
public class SessionFeedbackCoachee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_feedback_id;

    @Column(name = "explanation_rating")
    private int explanationRating;

    @Column(name = "useful_rating")
    private int usefulRating;

    @Column(name = "comment1")
    private String comment1;

    @Column(name = "comment2")
    private String comment2;

    public Long getSession_feedback_id() {
        return session_feedback_id;
    }

    public SessionFeedbackCoachee setSession_feedback_id(Long session_feedback_id) {
        this.session_feedback_id = session_feedback_id;
        return this;
    }

    public int getExplanationRating() {
        return explanationRating;
    }

    public SessionFeedbackCoachee setExplanationRating(int explanationRating) {
        this.explanationRating = explanationRating;
        return this;
    }

    public int getUsefulRating() {
        return usefulRating;
    }

    public SessionFeedbackCoachee setUsefulRating(int usefulRating) {
        this.usefulRating = usefulRating;
        return this;
    }

    public String getComment1() {
        return comment1;
    }

    public SessionFeedbackCoachee setComment1(String comment1) {
        this.comment1 = comment1;
        return this;
    }

    public String getComment2() {
        return comment2;
    }

    public SessionFeedbackCoachee setComment2(String comment2) {
        this.comment2 = comment2;
        return this;
    }

    public SessionFeedbackCoachee() {
    }
}

