package com.example.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pacman implements GamingConsole{

    public void Up(){
        System.out.println("Up");
    }
    public void Down(){
        System.out.println("Down");
    }
    public void Right(){
        System.out.println("Right");
    }
    public void Left(){
        System.out.println("Left");
    }

}
