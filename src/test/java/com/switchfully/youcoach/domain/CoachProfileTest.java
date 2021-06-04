package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.util.EmailGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoachProfileTest {

    AccountImpl account;

    @BeforeEach
    void setUp() {
        account = AccountImpl.builder()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE))
                .setPassword("PAssword1")
                .setEmail(EmailGenerator.createRandomEmail())
                .build();
    }

    @Test
    void givenCoachWithIntroductionNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> CoachProfile.builder()
                .setAccount(account)
                .setAvailability("ava")
                .setIntroduction(null)
                .build());
    }

    @Test
    void givenCoachWithAvailabilityBlank_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> CoachProfile.builder()
                .setAccount(account)
                .setAvailability(" ")
                .setIntroduction("dfdf")
                .build());
    }

}
