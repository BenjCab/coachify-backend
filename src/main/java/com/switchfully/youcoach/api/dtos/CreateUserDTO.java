package com.switchfully.youcoach.api.dtos;

public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;

    public CreateUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;
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
}
