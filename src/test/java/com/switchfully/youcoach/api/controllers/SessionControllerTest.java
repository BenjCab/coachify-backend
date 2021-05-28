//package com.switchfully.youcoach.api.controllers;
//
//import com.switchfully.youcoach.api.Account;
//import com.switchfully.youcoach.api.DTOs.SessionDTO;
//import com.switchfully.youcoach.api.mappers.SessionMapper;
//import com.switchfully.youcoach.domain.AccountImpl;
//import com.switchfully.youcoach.domain.CoachProfile;
//import com.switchfully.youcoach.domain.Topic;
//import com.switchfully.youcoach.domain.TopicByCoach;
//import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtAuthenticationFilter;
//import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
//import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
//import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
//import com.switchfully.youcoach.service.AccountService;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.annotation.DirtiesContext;
//
//import javax.servlet.http.HttpServletResponse;
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
//
//    @Test
//    @WithMockUser(username = "admin", authorities = {"USER", "ADMIN"})
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
//        AccountImpl coachee = AccountImpl.builder()
//                .setFirstName("Bart")
//                .setLastName("Simpson")
//                .setEmail("bart@test.com")
//                .setPassword("password")
//                .setEnabled(true)
//                .setAuthorities(List.of(Authority.COACHEE))
//                .build();
//
//        Account account = accountService.createAccount(new CreateSecuredUserDto(coachee.getFirstName(), coachee.getLastName(), coachee.getEmail(), coachee.getPassword()));
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
//        sessionDTO.setCoacheeId(account.getId())
//                .setCoachId(account.getId())
//                .setSubject("testSubject")
//                .setLocation("testLocation")
//                .setRemarks("testRemarks")
//                .setDate(LocalDate.now())
//                .setTime(LocalTime.now())
//                .setStatus("Requested");
//
//     //   String token = jwtGenerator.generateToken(coachee);
//
///*        HttpServletResponse response;
//
//        response.addHeader("Authorization", "Bearer " + token);
//        response.addHeader("Access-Control-Expose-Headers", "Authorization");*/
//
//        ResponseEntity<SessionDTO> responseEntity = this.testRestTemplate
//                .postForEntity("http://localhost:" + port + "/sessions", sessionDTO, SessionDTO.class);
//
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertNotEquals(responseEntity.getBody(), null);
//        assertEquals(responseEntity.getBody().getLocation(), "testLocation2");
//    }
//
//}
