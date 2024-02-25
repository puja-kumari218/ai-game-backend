package com.example.aigame.controller;

import com.example.aigame.service.TurnBasedGameService;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private TurnBasedGameService gameService;

    @PostMapping("/play")
    public ResponseEntity<String> playGame(@RequestParam String username, @RequestParam int coinsPicked) {
        String result = gameService.playGame(username, coinsPicked);
        return ResponseEntity.ok(result);
    }
}
