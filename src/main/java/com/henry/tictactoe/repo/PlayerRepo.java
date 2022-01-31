package com.henry.tictactoe.repo;

import com.henry.tictactoe.object.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    @Query("SELECT u FROM Player u WHERE u.username = ?1 ")
    Player findByUsername(String username);
}
