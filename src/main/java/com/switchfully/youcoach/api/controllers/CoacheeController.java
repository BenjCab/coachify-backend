package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.ResetPasswordDTO;
import com.switchfully.youcoach.api.mappers.AccountMapper;
import com.switchfully.youcoach.service.AccountService;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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

    @GetMapping(path= "/{id}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public SecuredUserDto getUserById(@PathVariable Long id) {
        return accountMapper.toUserDto(accountService.getUserById(id));
    }

    @PostMapping(path="/reset-password", produces ="application/json", consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public boolean resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
        logger.info("request for checking if reset password token exist " + resetPasswordDTO.getEmail());
        return accountService.resetPassword(resetPasswordDTO);
    }
    @GetMapping(path="/reset-password/{resetPasswordId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Boolean resetPasswordTokenExist(@PathVariable String resetPasswordId){
        logger.info("request for checking if reset password token exist " + resetPasswordId);
        return accountService.resetPasswordTokenExist(resetPasswordId);
    }
}
