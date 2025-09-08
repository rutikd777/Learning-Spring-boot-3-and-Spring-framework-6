package com.example.SpringFrameWork.Spring_Frame_Work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.Name;
import java.util.Arrays;

@SpringBootApplication
public class SpringFrameWorkApplication {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(HelloWorld.class);
		System.out.println(context.getBean("name"));

		System.out.println(context.getBean("age"));

		System.out.println(context.getBean("person"));

		System.out.println(context.getBean("person2MethodCall"));

		System.out.println(context.getBean("person3Parameters"));

		System.out.println(context.getBean("address2"));

		System.out.println(context.getBean(Address.class));

//		Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);

	}

}







