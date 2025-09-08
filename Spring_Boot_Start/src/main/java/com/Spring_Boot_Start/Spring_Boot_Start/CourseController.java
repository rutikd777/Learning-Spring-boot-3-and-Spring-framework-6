package com.Spring_Boot_Start.Spring_Boot_Start;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retriveAllCourses(){
         return Arrays.asList(
                new Course(1, "Java", "Ranga"),
                new Course(2, "Web", "Love Babbar"),
                 new Course(3,"C++", "Love Babbar"),
                 new Course(4, "DevOps", "Ranga")
        );
    }

}
