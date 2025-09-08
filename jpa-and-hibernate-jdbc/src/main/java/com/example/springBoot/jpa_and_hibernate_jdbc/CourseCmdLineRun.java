package com.example.springBoot.jpa_and_hibernate_jdbc;

import com.example.springBoot.jpa_and_hibernate_jdbc.JPA.CourseJPA_Repo;
import com.example.springBoot.jpa_and_hibernate_jdbc.Spring_Data_JPA.Data_JPA;
import com.example.springBoot.jpa_and_hibernate_jdbc.jdbc.CourseJDBCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCmdLineRun implements CommandLineRunner {

    @Autowired
//    private CourseJDBCRepo Repo;
//    private CourseJPA_Repo Repo;
      private Data_JPA Repo;


    @Override
    public void run(String... args) throws Exception {
        Repo.save(new Course(1,"Java", "Apna clg"));
        Repo.save(new Course(2,"CPP", "Love Babbar"));
        Repo.save(new Course(3,"React", "Harsh Sharma"));
        Repo.save(new Course(4,"AWS", "Ranga"));

        System.out.println(Repo.findById(1l));
        System.out.println(Repo.findAll());
        System.out.println(Repo.count());

        System.out.println(Repo.findByAuthor("Ranga"));
        System.out.println(Repo.findByAuthor("Love Babbar"));

        Repo.deleteById(2l);
    }
}
