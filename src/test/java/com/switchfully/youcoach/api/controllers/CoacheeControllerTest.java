package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.ResetPasswordDTO;
import com.switchfully.youcoach.api.DTOs.UpdateCoachProfileDTO;
import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.domain.AccountRepository;
import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.domain.CoachRepository;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;
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
class CoacheeControllerTest {

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mvc;

    AccountImpl account;
    SecuredUserDto securedUserDto;
    ResetPasswordDTO resetPasswordDTO;

    @BeforeEach
    void generateAccount() {

        account = AccountImpl.builder()
                .setFirstName("Bart")
                .setLastName("Simpson")
                .setEmail(EmailGenerator.createRandomEmail())
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACHEE, Authority.COACH))
                .build();

        accountRepository.save(account);

    }


    @Test
    public void shouldGetCoacheeById() throws Exception {
        String token = "Bearer " + jwtGenerator.generateToken(account);

        securedUserDto = new SecuredUserDto(account.getId(), account.getEmail(), account.isAccountEnabled(),
                account.getFirstName(),account.getLastName(),account.getAuthorities());

        mvc.perform(MockMvcRequestBuilders
                .get("/users/{id}", account.getId())
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(securedUserDto.getEmail()))
                .andExpect(jsonPath("$.firstName").value(securedUserDto.getFirstName()));
    }
}
