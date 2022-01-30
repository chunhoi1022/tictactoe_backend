package com.henry.tictactoe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.henry.tictactoe.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="auth")
public class AuthController {
    private final AuthService authService;
    Logger logger= LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(AuthService authService) {
        this.authService=authService;
    }

    @PostMapping
    public String login(@RequestBody String jsonString) throws JsonProcessingException {
        logger.info("Request parms:" + jsonString);
        return authService.login(jsonString);
    }
}
