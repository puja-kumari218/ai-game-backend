package com.example.aigame.service;

import com.example.aigame.model.User;
import com.example.aigame.model.GameHistory;
import com.example.aigame.repository.UserRepository;
import com.example.aigame.repository.GameHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnBasedGameService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameHistoryRepository gameHistoryRepository;

    public String playGame(String username, int coinsPicked) {
        // Implement game logic and return result (win/lose)
        // For simplicity, assuming a random result for the example
        boolean aiWins = Math.random() < 0.5;

        User user = userRepository.findByUsername(username);

        String result = aiWins ? "lose" : "win";

        // Save game history
        GameHistory gameHistory = new GameHistory(user, result);
        gameHistoryRepository.save(gameHistory);

        return result;
    }
}
