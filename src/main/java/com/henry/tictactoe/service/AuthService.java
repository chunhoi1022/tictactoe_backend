package com.henry.tictactoe.service;

import com.henry.tictactoe.Utility.JWTUtility;
import com.henry.tictactoe.repo.PlayerRepo;
import com.henry.tictactoe.request.AuthRequest;
import com.henry.tictactoe.response.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private PlayerRepo userRepo;
    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    Logger logger= LoggerFactory.getLogger(AuthService.class);


    public AuthResponse login(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails
                = userService.loadUserByUsername(authRequest.getUsername());
        logger.info(userDetails.toString());

        final String token =
                jwtUtility.generateToken(userDetails);

        logger.info("Token:" + token);
        return new AuthResponse(token);

    }

}
