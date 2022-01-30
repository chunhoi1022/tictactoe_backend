package com.henry.tictactoe.service;

import com.henry.tictactoe.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserRepo userRepo;

    public String login(String jsonString){
        return "";
    }

}
