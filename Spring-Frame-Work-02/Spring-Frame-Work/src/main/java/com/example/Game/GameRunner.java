package com.example.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GamingConsole game;

    public GameRunner(@Qualifier("SuperContraQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run(){
        System.out.println("Game is running...");
        game.Up();
        game.Down();
        game.Left();
        game.Right();
    }
}
