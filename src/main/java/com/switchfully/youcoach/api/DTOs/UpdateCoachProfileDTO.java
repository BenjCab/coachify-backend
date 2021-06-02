package com.switchfully.youcoach.api.DTOs;

public class UpdateCoachProfileDTO {
    private String introduction;
    private String availability;

    public String getIntroduction() {
        return introduction;
    }

    public UpdateCoachProfileDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public String getAvailability() {
        return availability;
    }

    public UpdateCoachProfileDTO setAvailability(String availability) {
        this.availability = availability;
        return this;
    }
}
