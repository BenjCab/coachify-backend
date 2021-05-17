package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.dtos.CreateUserDTO;
import com.switchfully.youcoach.api.dtos.UserDTO;
import com.switchfully.youcoach.api.mappers.CreateUserDTOMapper;
import com.switchfully.youcoach.api.mappers.UserDTOMapper;
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
class CoacheeControllerTest {
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

//    @Test
//    void whenCreatingUserWithFirstNameNull_thenGetBadRequest() {
//        //Given
//        CreateUserDTO createUserDTO1 = new CreateUserDTO();
//        createUserDTO1.setEmail("test@test.com").setFirstName(null).setLastName("Test");
//
//        //When
//        ResponseEntity<UserDTO> responseEntity1 = this.testRestTemplate
//                .postForEntity("http://localhost:" + port + "/users", createUserDTO1, UserDTO.class);
//
//        //Then
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
//    }
//    @Test
//    void whenCreatingUserWithInvalidEmail_thenGetBadRequest() {
//        //Given
//        CreateUserDTO createUserDTO2 = new CreateUserDTO();
//        createUserDTO2.setEmail("@test.co").setFirstName("Test").setLastName("Test");
//        //When
//        ResponseEntity<UserDTO> responseEntity2 = this.testRestTemplate
//                .postForEntity("http://localhost:" + port + "/users", createUserDTO2, UserDTO.class);
//        //Then
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity2.getStatusCode());
//    }
//
//    @Test
//    void whenCreatingUserWithLastNameBlank_thenGetBadRequest() {
//        //Given
//        CreateUserDTO createUserDTO3 = new CreateUserDTO();
//        createUserDTO3.setEmail("test@test.com").setFirstName("Test").setLastName("   ");
//        //When
//        ResponseEntity<UserDTO> responseEntity3 = this.testRestTemplate
//                .postForEntity("http://localhost:" + port + "/users", createUserDTO3, UserDTO.class);
//        //Then
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity3.getStatusCode());
//    }
}
