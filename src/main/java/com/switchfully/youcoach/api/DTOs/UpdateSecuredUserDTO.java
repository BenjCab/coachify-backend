package com.switchfully.youcoach.api.DTOs;

public class UpdateSecuredUserDTO {
    private String firstName;
    private String lastName;
    private String email;

    public UpdateSecuredUserDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UpdateSecuredUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UpdateSecuredUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UpdateSecuredUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
