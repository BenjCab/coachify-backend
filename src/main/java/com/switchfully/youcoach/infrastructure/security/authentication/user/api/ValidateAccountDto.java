package com.switchfully.youcoach.infrastructure.security.authentication.user.api;

public class ValidateAccountDto {
    private String email;
    private String verificationCode;

    public String getEmail() {
        return email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
