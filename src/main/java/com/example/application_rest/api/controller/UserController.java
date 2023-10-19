package com.example.application_rest.api.controller;

import com.example.application_rest.api.dto.UserDTO;
import com.example.application_rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserDTO getUser(@RequestParam Integer id) {
        Optional<UserDTO> user = userService.getUserDTO(id);
        if (user.isPresent()) {
            logger.info("User found with ID: " + id);
            return user.get();
        } else {
            logger.warn("User not found with ID: " + id);
            return null;
        }
    }
}
