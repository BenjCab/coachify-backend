package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.dtos.CreateUserDTO;
import com.switchfully.youcoach.api.dtos.UserDTO;
import com.switchfully.youcoach.api.mappers.CreateUserDTOMapper;
import com.switchfully.youcoach.api.mappers.UserDTOMapper;
import com.switchfully.youcoach.domain.entities.User;
import com.switchfully.youcoach.service.UserService;
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

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Autowired
    private CreateUserDTOMapper createUserDTOMapper;

    @Test
    void testCreateUser() {
        CreateUserDTO createUserDTO = new CreateUserDTO();

        createUserDTO.setEmail("test@test.com").setFirstName("Testa").setLastName("Test");

        ResponseEntity<UserDTO> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/users", createUserDTO, UserDTO.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotEquals(responseEntity.getBody(), null);
        assertEquals(responseEntity.getBody().getFirstName(),
                userDTOMapper.toDTO(createUserDTOMapper.toEntity(createUserDTO)).getFirstName());
    }
}
