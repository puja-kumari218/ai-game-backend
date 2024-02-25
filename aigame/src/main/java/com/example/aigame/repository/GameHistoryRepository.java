package com.example.aigame.repository;

import com.example.aigame.model.GameHistory;
import com.example.aigame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameHistoryRepository extends JpaRepository<GameHistory, Long> {
    List<GameHistory> findByUserOrderByTimestampDesc(User user);
}