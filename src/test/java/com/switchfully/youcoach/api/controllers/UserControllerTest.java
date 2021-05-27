package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testCreateUser() {
        CreateSecuredUserDto createUserDTO = new CreateSecuredUserDto("Testa", "Test", "controllertest@test.com", "1234Password");

        ResponseEntity<SecuredUserDto> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "security/account", createUserDTO, SecuredUserDto.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);

    }

    @Test
    void givenAnInvalidPassword_whenCreatingUser_thenReturnBasRequest() {
        CreateSecuredUserDto createUserDTO = new CreateSecuredUserDto("Testa", "Test", "controllertest2@test.com", "1234");

        ResponseEntity<SecuredUserDto> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "security/account", createUserDTO, SecuredUserDto.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void givenAnInvalidEmail_whenCreatingUser_thenReturnBasRequest() {
        CreateSecuredUserDto createUserDTO = new CreateSecuredUserDto("Testa", "Test", "controllertest3test.com", "PAssword4");

        ResponseEntity<SecuredUserDto> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "security/account", createUserDTO, SecuredUserDto.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}
