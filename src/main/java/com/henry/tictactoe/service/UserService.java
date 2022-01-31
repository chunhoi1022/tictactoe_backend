package com.henry.tictactoe.service;

import com.henry.tictactoe.object.Player;
import com.henry.tictactoe.repo.PlayerRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private PlayerRepo playerRepo;

    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // logic to get the user from the database
        Player player = playerRepo.findByUsername(username);
        if (player == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return new User(player.getUsername(),player.getPassword(),new ArrayList<>());
    }
}
