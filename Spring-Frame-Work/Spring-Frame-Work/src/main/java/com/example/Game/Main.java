package com.example.Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.Name;
import java.util.Arrays;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(GamingConfig.class);

        context.getBean(GamingConsole.class).Up();
        context.getBean(GameRunner.class).run();

    }

}







