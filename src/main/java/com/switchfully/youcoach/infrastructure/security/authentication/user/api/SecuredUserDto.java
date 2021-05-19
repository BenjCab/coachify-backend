package com.switchfully.youcoach.infrastructure.security.authentication.user.api;

import java.util.Objects;

public class SecuredUserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean accountEnabled;

    public SecuredUserDto(long id, String email, boolean accountEnabled, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.accountEnabled = accountEnabled;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SecuredUserDto() {
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAccountEnabled() {
        return accountEnabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecuredUserDto that = (SecuredUserDto) o;
        return id == that.id &&
                accountEnabled == that.accountEnabled &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, accountEnabled);
    }
}
