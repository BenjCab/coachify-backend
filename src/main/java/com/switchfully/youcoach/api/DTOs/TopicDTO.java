package com.switchfully.youcoach.api.DTOs;

public class TopicDTO {
    private String topicName;
    private Boolean grade1;
    private Boolean grade2;
    private Boolean grade3;

    public String getTopicName() {
        return topicName;
    }
    public TopicDTO setTopicName(String topicName) {
        this.topicName = topicName;
        return this;
    }
    public Boolean getGrade1() {
        return grade1;
    }
    public TopicDTO setGrade1(Boolean grade1) {
        this.grade1 = grade1;
        return this;
    }
    public Boolean getGrade2() {
        return grade2;
    }
    public TopicDTO setGrade2(Boolean grade2) {
        this.grade2 = grade2;
        return this;
    }
    public Boolean getGrade3() {
        return grade3;
    }
    public TopicDTO setGrade3(Boolean grade3) {
        this.grade3 = grade3;
        return this;
    }
}
