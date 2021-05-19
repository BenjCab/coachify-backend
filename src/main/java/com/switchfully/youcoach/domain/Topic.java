package com.switchfully.youcoach.domain;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_name")
    private String topicName;

    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public Topic setId(Long id) {
        this.id = id;
        return this;
    }

    public Topic setTopicName(String name) {
        this.topicName = name;
        return this;
    }
}
