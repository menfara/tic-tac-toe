package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.GameService;

@RequiredArgsConstructor
public class GameRunner implements Game {

    private final GameService gameService;

    @Override
    public void start() {
        gameService.start();
    }
}
