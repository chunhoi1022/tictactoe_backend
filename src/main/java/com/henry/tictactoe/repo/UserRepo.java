package com.henry.tictactoe.repo;

import com.henry.tictactoe.object.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.function.Function;

public interface UserRepo extends JpaRepository<User, Long> {

}
