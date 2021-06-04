package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.SessionDTO;
import com.switchfully.youcoach.domain.*;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.service.SessionService;
import com.switchfully.youcoach.util.EmailGenerator;
import com.switchfully.youcoach.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SessionControllerTest {

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private MockMvc mvc;

    AccountImpl coach;
    AccountImpl coachee;
    CoachProfile coachProfile;
    SessionDTO sessionDTO;

    @BeforeEach
    void generateSession() {
        coach = AccountImpl.builder()
                .setFirstName("Testa")
                .setLastName("Test")
                .setEmail(EmailGenerator.createRandomEmail())
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        accountRepository.save(coach);

        coachee = AccountImpl.builder()
                .setFirstName("Bart")
                .setLastName("Simpson")
                .setEmail(EmailGenerator.createRandomEmail())
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE))
                .build();

        accountRepository.save(coachee);

        coachProfile = CoachProfile.builder()
                .setAccount(coach)
                .setAvailability("Sunday")
                .setIntroduction("intro")
                .build();

        coachRepository.save(coachProfile);

        sessionDTO = new SessionDTO().setCoacheeId(coachee.getId())
                .setCoachId(coachProfile.getId())
                .setSubject("testSubject")
                .setLocation("testLocation")
                .setRemarks("testRemarks")
                .setDate(LocalDate.now())
                .setTime(LocalTime.now())
                .setStatus("Requested");
    }

    @Test
    public void shouldGenerateSession() throws Exception {
        String token = "Bearer " + jwtGenerator.generateToken(coach);

        mvc.perform(MockMvcRequestBuilders
                .post("/sessions")
                .content(TestUtil.asJsonString(sessionDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.subject").value(sessionDTO.getSubject()))
                .andExpect(jsonPath("$.status").value(sessionDTO.getStatus()))
                .andExpect(jsonPath("$.location").value(sessionDTO.getLocation()));
    }

    @Test
    public void shouldGetSessionByCoach() throws Exception {

        String token = "Bearer " + jwtGenerator.generateToken(coach);

        mvc.perform(MockMvcRequestBuilders
                .get("/coaches/{id}/sessions", coachProfile.getId())
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetSessionByCoachee() throws Exception {

        String token = "Bearer " + jwtGenerator.generateToken(coach);

        mvc.perform(MockMvcRequestBuilders
                .get("/coachees/{id}/sessions", coachee.getId())
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSetSessionStatus() throws Exception {
        String token = "Bearer " + jwtGenerator.generateToken(coach);

        Session session = sessionService.createSession(sessionDTO);

        mvc.perform(MockMvcRequestBuilders
                .post("/sessions/{id}/set-status", session.getSessionId())
                .content(TestUtil.asJsonString(sessionDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


}
