package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.Account;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public SecuredUserDto toUserDto(Account account) {
        return new SecuredUserDto(account.getId(), account.getEmail(), account.isAccountEnabled(), account.getFirstName(), account.getLastName(), account.getAuthorities());
    }
}
