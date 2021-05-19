package com.switchfully.youcoach.api.dtos;

import java.util.List;

public class OverviewCoachDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String image;
    private List<TopicDTO> topicsByCoach;
    private String introduction;
    private String availability;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public OverviewCoachDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OverviewCoachDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public OverviewCoachDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OverviewCoachDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public OverviewCoachDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
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
