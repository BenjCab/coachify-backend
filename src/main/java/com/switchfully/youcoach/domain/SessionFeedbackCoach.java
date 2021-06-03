package com.switchfully.youcoach.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback_coach")
public class SessionFeedbackCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_feedback_id;

    @Column(name = "rating1")
    private int rating1;

    @Column(name = "rating2")
    private int rating2;

    @Column(name = "comment1")
    private String comment1;

    @Column(name = "comment2")
    private String comment2;

    public SessionFeedbackCoach() {
    }

    public Long getSession_feedback_id() {
        return session_feedback_id;
    }

    public SessionFeedbackCoach setSession_feedback_id(Long session_feedback_id) {
        this.session_feedback_id = session_feedback_id;
        return this;
    }

    public int getRating1() {
        return rating1;
    }

    public SessionFeedbackCoach setRating1(int rating1) {
        this.rating1 = rating1;
        return this;
    }

    public int getRating2() {
        return rating2;
    }

    public SessionFeedbackCoach setRating2(int rating2) {
        this.rating2 = rating2;
        return this;
    }

    public String getComment1() {
        return comment1;
    }

    public SessionFeedbackCoach setComment1(String comment1) {
        this.comment1 = comment1;
        return this;
    }

    public String getComment2() {
        return comment2;
    }

    public SessionFeedbackCoach setComment2(String comment2) {
        this.comment2 = comment2;
        return this;
    }
}



