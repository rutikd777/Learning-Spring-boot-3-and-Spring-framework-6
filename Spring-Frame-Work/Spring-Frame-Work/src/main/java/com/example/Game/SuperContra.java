package com.example.Game;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "game.provider", havingValue = "supra")
public class SuperContra implements  GamingConsole{

    public void Up(){
        System.out.println("Jumps");
    }

    public void Down(){
        System.out.println("Sit down");
    }

    public void Left(){
        System.out.println("Go left");
    }

    public void Right(){
        System.out.println("Fire the bullet");
    }
}
