package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.UpdateCoachProfileDTO;
import com.switchfully.youcoach.domain.*;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.service.CoachProfileService;
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

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CoachControllerTest {

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CoachProfileService coachService;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private MockMvc mvc;

    AccountImpl account;
    CoachProfile coachProfile;
    UpdateCoachProfileDTO updateCoachProfileDTO;

    @BeforeEach
    void generateSession() {

        account = AccountImpl.builder()
                .setFirstName("Bart")
                .setLastName("Simpson")
                .setEmail(EmailGenerator.createRandomEmail())
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE, Authority.COACH))
                .build();

        accountRepository.save(account);

        coachProfile = CoachProfile.builder()
                .setAccount(account)
                .setAvailability("Sunday")
                .setImage("./assets/images/profile-picture-coach.png")
                .setIntroduction("intro")
                .build();

        coachRepository.save(coachProfile);
    }

    @Test
    public void shouldUpdateCoachProfile() throws Exception {
        String token = "Bearer " + jwtGenerator.generateToken(account);

        updateCoachProfileDTO = new UpdateCoachProfileDTO()
                .setAvailability("Monday")
                .setIntroduction("updated introduction");

        mvc.perform(MockMvcRequestBuilders
                .post("/coaches/{id}/coachInformation", coachProfile.getId())
                .content(TestUtil.asJsonString(updateCoachProfileDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.introduction").value(updateCoachProfileDTO.getIntroduction()))
                .andExpect(jsonPath("$.availability").value(updateCoachProfileDTO.getAvailability()));
    }

    @Test
    public void shouldGetCoachById() throws Exception {

        String token = "Bearer " + jwtGenerator.generateToken(account);

        mvc.perform(MockMvcRequestBuilders
                .get("/coaches/{id}", coachProfile.getId())
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCoaches() throws Exception {

        String token = "Bearer " + jwtGenerator.generateToken(account);

        mvc.perform(MockMvcRequestBuilders
                .get("/coaches")
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllTopicNames() throws Exception {

        String token = "Bearer " + jwtGenerator.generateToken(account);

        mvc.perform(MockMvcRequestBuilders
                .get("/coaches/topicNames")
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCoachIdByCoacheeId() throws Exception {

        String token = "Bearer " + jwtGenerator.generateToken(account);

        mvc.perform(MockMvcRequestBuilders
                .get("/users/{id}/coach", account.getId())
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
