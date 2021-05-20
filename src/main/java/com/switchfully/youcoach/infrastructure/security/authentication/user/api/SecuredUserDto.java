package com.switchfully.youcoach.infrastructure.security.authentication.user.api;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;

import java.util.List;
import java.util.Objects;

public class SecuredUserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean accountEnabled;
    private List<Authority> authorities;

    public SecuredUserDto(long id, String email, boolean accountEnabled,
                          String firstName, String lastName, List<Authority> authorities) {
        this.id = id;
        this.email = email;
        this.accountEnabled = accountEnabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
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

    public List<Authority> getAuthorities() {
        return authorities;
    }
}
