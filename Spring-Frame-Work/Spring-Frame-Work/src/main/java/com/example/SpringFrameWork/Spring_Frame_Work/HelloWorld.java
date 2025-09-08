package com.example.SpringFrameWork.Spring_Frame_Work;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person (String name, int age, Address address){};
record Address (String street, String city){};

@Configuration
public class HelloWorld {

    @Bean
    public String name(){
        return "Rutik";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address){
        return new Person(name, age,address);
    }

    @Bean
    public Person person(){
        return new Person("Rutik", 22, new Address("NewYork", "LA"));
    }

    @Bean(name = "address2")
    public Address address(){
        return new Address("Bajajnagar", "Chh.Sambhajinagar");
    }

    @Bean(name = "address3")
    @Primary
    public Address address3(){
        return new Address("Bajajnagar", "Chh.Sambhajinagar");
    }

}
