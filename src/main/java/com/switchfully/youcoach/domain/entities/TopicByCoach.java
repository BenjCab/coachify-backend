package com.switchfully.youcoach.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topic_by_coach")
public class TopicByCoach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @Column(name = "grade1")
    private Boolean grade1;
    @Column(name = "grade2")
    private Boolean grade2;
    @Column(name = "grade3")
    private Boolean grade3;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    public TopicByCoach() {
    }

    public Long getId() {
        return id;
    }

    public TopicByCoach setId(Long id) {
        this.id = id;
        return this;
    }

    public Topic getTopic() {
        return topic;
    }

    public TopicByCoach setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public Boolean getGrade1() {
        return grade1;
    }

    public TopicByCoach setGrade1(Boolean grade1) {
        this.grade1 = grade1;
        return this;
    }

    public Boolean getGrade2() {
        return grade2;
    }

    public TopicByCoach setGrade2(Boolean grade2) {
        this.grade2 = grade2;
        return this;
    }

    public Boolean getGrade3() {
        return grade3;
    }

    public TopicByCoach setGrade3(Boolean grade3) {
        this.grade3 = grade3;
        return this;
    }

    public Coach getCoach() {
        return coach;
    }

    public TopicByCoach setCoach(Coach coach) {
        this.coach = coach;
        return this;
    }
}
