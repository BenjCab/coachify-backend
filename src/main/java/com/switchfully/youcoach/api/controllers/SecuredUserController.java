package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.infrastructure.security.authentication.user.api.*;
import com.switchfully.youcoach.infrastructure.validations.ValidationUtil;
import com.switchfully.youcoach.service.SecuredUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/security/account")
@CrossOrigin
public class SecuredUserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SecuredUserController.class);

    private final SecuredUserService securedUserService;


    public SecuredUserController(SecuredUserService securedUserService) {
        this.securedUserService = securedUserService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public SecuredUserDto createUser(@RequestBody CreateSecuredUserDto createSecuredUserDto) {
        if (!ValidationUtil.isEmailValid(createSecuredUserDto.getEmail())) {
            throw new IllegalStateException("Email is not valid !");
        }
        if (!isPasswordValid(createSecuredUserDto.getPassword())) {
            throw new IllegalStateException("Password needs te be 8 characters : --> 1 capital, 1 lowercase and 1 one number ");
        }
        createSecuredUserDto.setEmail(createSecuredUserDto.getEmail().toLowerCase());
        SecuredUserDto securedUserDto = securedUserService.registerAccount(createSecuredUserDto);
        LOGGER.info("Added the user with email "+securedUserDto.getEmail());
        return securedUserDto;
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", path = "/validate")
    public VerificationResultDto validateAccount(@RequestBody ValidateAccountDto validationData) {
        return securedUserService.validateAccount(validationData);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", path = "/resend-validation")
    public void resendValidation(@RequestBody ResendVerificationDto validationData) {
        securedUserService.resendValidation(validationData);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(consumes = "application/json;charset=UTF-8", path = "/password/request-reset")
    public void requestPasswordResetToken(@RequestBody PasswordResetRequestDto resetRequest) {
        securedUserService.requestPasswordReset(resetRequest);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", path = "/password")
    public PasswordChangeResultDto performPasswordChange(@RequestBody PasswordChangeRequestDto changeRequest) {
        if(!isPasswordValid(changeRequest.getPassword())){
            return new PasswordChangeResultDto(false);
        }
        return securedUserService.performPasswordChange(changeRequest);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidFieldsException(IllegalStateException ex, HttpServletResponse response) throws IOException {
        LOGGER.info(ex.getMessage());
        response.sendError(400, ex.getMessage());
    }

    boolean isPasswordValid(String password) {
        if (password == null) return false;

        String pattern = "(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }
}
