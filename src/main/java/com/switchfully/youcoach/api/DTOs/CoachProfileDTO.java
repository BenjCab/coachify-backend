package com.switchfully.youcoach.api.DTOs;

import com.switchfully.youcoach.api.DTOs.TopicDTO;

import java.util.List;

public class CoachProfileDTO {
    private String firstName;
    private String lastName;
    private String image;
    private List<TopicDTO> topicsByCoach;
    private String introduction;
    private String availability;
    private String email;
    private Long id;

    public String getIntroduction() {
        return introduction;
    }

    public CoachProfileDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public CoachProfileDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CoachProfileDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CoachProfileDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }
    public CoachProfileDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public String getLastName() {
        return lastName;
    }
    public CoachProfileDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getImage() {
        return image;
    }
    public CoachProfileDTO setImage(String image) {
        this.image = image;
        return this;
    }
    public List<TopicDTO> getTopicsByCoach() {
        return topicsByCoach;
    }
    public CoachProfileDTO setTopicsByCoach(List<TopicDTO> topicsByCoach) {
        this.topicsByCoach = topicsByCoach;
        return this;
    }
}
