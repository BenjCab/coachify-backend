package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.util.EmailGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopicByCoachTest {
    AccountImpl account;
    CoachProfile coachProfile;
    Topic topic;

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

        topic = new Topic().setTopicName("Angular");
    }

    @Test
    void givenTopicByCoachWithTopicNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new TopicByCoach()
                .setCoachProfile(coachProfile)
                .setTopic(null)
                .setGrade1(true)
                .setGrade2(true)
                .setGrade3(false));
    }

    @Test
    void givenTopicByCoachWithCoachProfileNull_thenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new TopicByCoach()
                .setCoachProfile(null)
                .setTopic(topic)
                .setGrade1(true)
                .setGrade2(true)
                .setGrade3(false));
    }
}
