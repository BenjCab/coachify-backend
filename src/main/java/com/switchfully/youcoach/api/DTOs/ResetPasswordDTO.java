package com.switchfully.youcoach.api.DTOs;

public class ResetPasswordDTO {
    private String email;
    private String resetPasswordId;
    private String password;
    public ResetPasswordDTO setEmail(String email) {
        this.email = email;
        return this;
    }
    public ResetPasswordDTO setResetPasswordId(String resetPasswordId) {
        this.resetPasswordId = resetPasswordId;
        return this;
    }
    public ResetPasswordDTO setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public String getResetPasswordId() {
        return resetPasswordId;
    }
    public String getPassword() {
        return password;
    }
}
