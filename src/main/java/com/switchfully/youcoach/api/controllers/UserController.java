package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.dtos.CreateUserDTO;
import com.switchfully.youcoach.api.dtos.UserDTO;
import com.switchfully.youcoach.api.mappers.CreateUserDTOMapper;
import com.switchfully.youcoach.api.mappers.UserDTOMapper;
import com.switchfully.youcoach.domain.entities.User;
import com.switchfully.youcoach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final CreateUserDTOMapper createUserDTOMapper;
    private final UserDTOMapper userDTOMapper;

    public UserController(UserService userService, CreateUserDTOMapper createUserDTOMapper, UserDTOMapper userDTOMapper) {
        this.userService = userService;
        this.createUserDTOMapper = createUserDTOMapper;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody CreateUserDTO createUserDTO) {
        User user = createUserDTOMapper.toEntity(createUserDTO);
        userService.addUser(user);
        logger.info(user + "is added.");
        return userDTOMapper.toDTO(user);
    }
}
