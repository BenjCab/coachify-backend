package com.switchfully.youcoach.api.dtos;

import java.util.List;

public class OverviewCoachDTO {
    private String firstName;
    private String lastName;
    private String image;
    private List<TopicDTO> topicsByCoach;

    public String getFirstName() {
        return firstName;
    }

    public OverviewCoachDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OverviewCoachDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImage() {
        return image;
    }

    public OverviewCoachDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public List<TopicDTO> getTopicsByCoach() {
        return topicsByCoach;
    }

    public OverviewCoachDTO setTopicsByCoach(List<TopicDTO> topicsByCoach) {
        this.topicsByCoach = topicsByCoach;
        return this;
    }
}
