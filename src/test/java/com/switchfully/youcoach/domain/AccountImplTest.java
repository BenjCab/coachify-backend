package com.switchfully.youcoach.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.util.EmailGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AccountImplTest {

    @Test
    void givenUserWithFirstNameNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> AccountImpl.builder()
                .setFirstName(null)
                .setLastName("LastName")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE))
                .setPassword("PAssword1")
                .setEmail(EmailGenerator.createRandomEmail()));
    }

    @Test
    void givenUserWithLastNameBlank_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> AccountImpl.builder()
                .setFirstName("Firstname")
                .setLastName(" ")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE))
                .setPassword("PAssword1")
                .setEmail(EmailGenerator.createRandomEmail()));
    }
}
