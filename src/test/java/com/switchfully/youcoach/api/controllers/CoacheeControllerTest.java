//package com.switchfully.youcoach.api.controllers;
//
//import com.switchfully.youcoach.api.mappers.AccountMapper;
//import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
//import com.switchfully.youcoach.infrastructure.security.authentication.user.api.SecuredUserDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.annotation.DirtiesContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//class CoacheeControllerTest {
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//    @Autowired
//    private AccountMapper accountMapper;
//
//    @Test
//    void testCreateUser() {
//        CreateSecuredUserDto createUserDTO = new CreateSecuredUserDto("Testa", "Test", "test@test.com", "1234");
//        ResponseEntity<SecuredUserDto> responseEntity = this.testRestTemplate
//                .postForEntity("http://localhost:" + port + "/users", createUserDTO, SecuredUserDto.class);
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertNotEquals(responseEntity.getBody(), null);
//        assertEquals(responseEntity.getBody().getFirstName(),
//                accountMapper.toUserDto(accountMapper.toEntity(createUserDTO)).getFirstName());
//    }
//
//}
