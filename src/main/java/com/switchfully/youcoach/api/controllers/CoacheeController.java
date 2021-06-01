package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.ResetPasswordDTO;
import com.switchfully.youcoach.api.mappers.AccountMapper;
import com.switchfully.youcoach.infrastructure.validations.ValidationUtil;
import com.switchfully.youcoach.service.AccountService;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class CoacheeController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private static final Logger logger = LoggerFactory.getLogger(CoacheeController.class);

    public CoacheeController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PreAuthorize("hasAnyAuthority('COACHEE, ADMIN')")
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public SecuredUserDto getUserById(@PathVariable Long id) {
        return accountMapper.toUserDto(accountService.getUserById(id));
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(path = "/reset-password", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Boolean resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        if (!ValidationUtil.isEmailValid(resetPasswordDTO.getEmail())) {
            throw new IllegalArgumentException("This email address is not valid.");
        }
        resetPasswordDTO.setEmail(resetPasswordDTO.getEmail().toLowerCase());
        logger.info(resetPasswordDTO.getResetPasswordId() + "    " + resetPasswordDTO.getEmail() + "     " + resetPasswordDTO.getPassword());
        return accountService.resetPassword(resetPasswordDTO);
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(path = "/reset-password/{resetPasswordId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Boolean resetPasswordTokenExist(@PathVariable String resetPasswordId) {
        return accountService.resetPasswordTokenExist(resetPasswordId);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping(path = "/reset-password/create-token/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createResetPasswordToken(@PathVariable String email) {
        logger.info("Received a request to reset the password from this email address : " + email);
        if (!ValidationUtil.isEmailValid(email)) {
            throw new IllegalArgumentException("This email address is not valid.");
        }
        email = email.toLowerCase();
        return accountService.createResetPasswordProcedure(email);
    }


}
