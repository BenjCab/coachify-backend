//package com.switchfully.youcoach.api.controllers;
//
//import com.switchfully.youcoach.api.DTOs.SessionDTO;
//import com.switchfully.youcoach.api.mappers.SessionMapper;
//import com.switchfully.youcoach.domain.AccountImpl;
//import com.switchfully.youcoach.domain.CoachProfile;
//import com.switchfully.youcoach.domain.Topic;
//import com.switchfully.youcoach.domain.TopicByCoach;
//import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
//import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
//import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
//import com.switchfully.youcoach.service.AccountService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.annotation.DirtiesContext;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//class SessionControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Autowired
//    private SessionMapper sessionMapper;
//
//    @Autowired
//    private JwtGenerator jwtGenerator;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Test
//    void testCreateSession() {
//        SessionDTO sessionDTO = new SessionDTO();
//
//        AccountImpl account1 = AccountImpl.builder()
//                .setFirstName("Testa")
//                .setLastName("Test")
//                .setEmail("test@test.com")
//                .setPassword("password")
//                .setEnabled(true)
//                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
//                .build();
//
//        accountService.createAccount(
//                new CreateSecuredUserDto(
//                        account1.getFirstName(),
//                        account1.getLastName(),
//                        account1.getEmail(),
//                        account1.getPassword()));
//
//        jwtGenerator.generateToken(account1);
//
//        AccountImpl coachee = AccountImpl.builder()
//                .setFirstName("Bart")
//                .setLastName("Simpson")
//                .setEmail("bart@test.com")
//                .setPassword("password")
//                .setEnabled(true)
//                .setAuthorities(List.of(Authority.COACHEE))
//                .build();
//
//        CoachProfile coachProfile1 = new CoachProfile()
//                .setAccount(account1)
//                .setAvailability("Sunday")
//                .setImage("./assets/images/profile-picture-coach.png")
//                .setIntroduction("intro");
//
//        Topic python = new Topic().setTopicName("Python");
//
//        TopicByCoach topicByCoach1 = new TopicByCoach()
//                .setTopic(python)
//                .setCoachProfile(coachProfile1)
//                .setGrade1(true)
//                .setGrade2(true)
//                .setGrade3(false);
//
//        sessionDTO.setCoacheeId(coachee.getId())
//                .setCoachId(1)
//                .setSubject("testSubject")
//                .setLocation("testLocation")
//                .setRemarks("testRemarks")
//                .setDate(LocalDate.now())
//                .setTime(LocalTime.now())
//                .setStatus("Requested");
//
//        ResponseEntity<SessionDTO> responseEntity = this.testRestTemplate
//                .postForEntity("http://localhost:" + port + "/sessions", sessionDTO, SessionDTO.class);
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertNotEquals(responseEntity.getBody(), null);
//        assertEquals(responseEntity.getBody().getLocation(), "testLocation2");
//    }
//
//}
