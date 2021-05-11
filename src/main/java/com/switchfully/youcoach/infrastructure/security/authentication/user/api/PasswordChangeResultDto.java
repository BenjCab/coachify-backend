package com.switchfully.youcoach.infrastructure.security.authentication.user.api;

public class PasswordChangeResultDto {
    private boolean passwordChanged;

    public PasswordChangeResultDto(){}
    public PasswordChangeResultDto(boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

}
