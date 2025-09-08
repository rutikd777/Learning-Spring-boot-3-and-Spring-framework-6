package com.example.Game;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "game.provider", havingValue = "mario")
public class MarioGame implements GamingConsole{

    public void Up(){
        System.out.println("Jump");
    }

    public void Down(){
        System.out.println("Goes in the hole");
    }

    public void Left(){
        System.out.println("Go Back");
    }
    public void Right(){
        System.out.println("Acclerate");
    }

}
