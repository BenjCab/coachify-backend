package com.switchfully.youcoach.api;

import com.switchfully.youcoach.service.AccountService;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class CoacheeController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public CoacheeController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping(path= "/{id}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public SecuredUserDto getUserById(@PathVariable Long id) {
        return accountMapper.toUserDto(accountService.getUserById(id));
    }

}
