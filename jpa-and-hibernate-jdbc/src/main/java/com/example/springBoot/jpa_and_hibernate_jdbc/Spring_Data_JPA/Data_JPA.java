package com.example.springBoot.jpa_and_hibernate_jdbc.Spring_Data_JPA;

import com.example.springBoot.jpa_and_hibernate_jdbc.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Data_JPA  extends JpaRepository<Course, Long> {

    //Custom method
    List<Course> findByAuthor(String author);
}
