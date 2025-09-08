package com.example.Game;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("package com.example.Game")
public class Main {

//    @Bean
//    public GamingConsole game(){
//        return new Pacman();
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        System.out.println("Parameter: " + game);
//        return new GameRunner(game);
//    }

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(Main.class);

//        context.getBean(GamingConsole.class).Up();
        context.getBean(GameRunner.class).run();

    }

}







