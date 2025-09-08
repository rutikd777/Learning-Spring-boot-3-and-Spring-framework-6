package com.Spring_Boot_Start.Spring_Boot_Start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBootStartApplication.class, args);
		System.out.println("Hello World");
	}

}
