package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.util.EmailGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    AccountImpl account;
    CoachProfile coachProfile;

    @BeforeEach
    void setUp() {
        account = AccountImpl.builder()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE))
                .setPassword("Password1")
                .setEmail(EmailGenerator.createRandomEmail())
                .build();

        coachProfile = CoachProfile.builder()
                .setAccount(account)
                .setAvailability("ava")
                .setIntroduction("introduction")
                .setImage("image")
                .build();
    }

    @Test
    void givenSessionWithCoachNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Session()
                .setStatus("Requested")
                .setCoachee(account)
                .setCoach(null)
                .setDate(LocalDate.now())
                .setLocation("Location")
                .setSubject("Subject")
                .setTime(LocalTime.now()));
    }

    @Test
    void givenSessionWithDateNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Session()
                .setStatus("Requested")
                .setCoachee(account)
                .setCoach(coachProfile)
                .setDate(null)
                .setLocation("Location")
                .setSubject("Subject")
                .setTime(LocalTime.now()));
    }

    @Test
    void givenSessionWithTimeNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Session()
                .setStatus("Requested")
                .setCoachee(account)
                .setCoach(coachProfile)
                .setDate(LocalDate.now())
                .setLocation("Location")
                .setSubject("Subject")
                .setTime(null));
    }

    @Test
    void givenSessionWithSubjectBlank_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Session()
                .setStatus("Requested")
                .setCoachee(account)
                .setCoach(coachProfile)
                .setDate(LocalDate.now())
                .setLocation("Location")
                .setSubject(" ")
                .setTime(LocalTime.now()));
    }

    @Test
    void givenSessionWithLocationEmpty_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Session()
                .setStatus("Requested")
                .setCoachee(account)
                .setCoach(coachProfile)
                .setDate(LocalDate.now())
                .setLocation("")
                .setSubject("Subject")
                .setTime(LocalTime.now()));
    }

}