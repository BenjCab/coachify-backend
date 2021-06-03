package com.switchfully.youcoach.api;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;

import java.util.List;

public interface Account {
    Long getId();

    String getEmail();

    String getFirstName();

    String getLastName();

    String getPassword();
    void setPassword(String encode);

    List<Authority> getAuthorities();

    boolean isAccountEnabled();
    void enableAccount();
    void setResetPasswordToken(String token);
    String getResetPasswordToken();

}
