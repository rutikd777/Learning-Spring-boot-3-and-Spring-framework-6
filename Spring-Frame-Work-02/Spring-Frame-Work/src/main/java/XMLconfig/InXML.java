package XMLconfig;

import com.example.Game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class InXML {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("Configuration.xml");
        System.out.println("----Classes----");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("----Values----");
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));

        context.getBean(GameRunner.class).run();
    }
}
