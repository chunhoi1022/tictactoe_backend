package com.henry.tictactoe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.henry.tictactoe.request.AuthRequest;
import com.henry.tictactoe.response.AuthResponse;
import com.henry.tictactoe.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;
    Logger logger= LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(AuthService authService) {
        this.authService=authService;
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest authRequest) throws Exception {
        logger.info("--------------/auth endpoint has been called-------------------");
        logger.info("Request parms:" + authRequest);
        return authService.login(authRequest);
    }
}
