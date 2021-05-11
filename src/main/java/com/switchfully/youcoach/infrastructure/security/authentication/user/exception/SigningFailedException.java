package com.switchfully.youcoach.infrastructure.security.authentication.user.exception;

public class SigningFailedException extends RuntimeException{
    public SigningFailedException(String msg){
        super(msg);
    }
}
