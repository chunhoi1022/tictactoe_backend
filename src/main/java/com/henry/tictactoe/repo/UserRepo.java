package com.henry.tictactoe.repo;

import com.henry.tictactoe.object.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
