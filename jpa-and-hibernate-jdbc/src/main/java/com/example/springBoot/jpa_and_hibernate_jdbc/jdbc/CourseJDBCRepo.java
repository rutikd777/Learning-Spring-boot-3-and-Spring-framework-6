package com.example.springBoot.jpa_and_hibernate_jdbc.jdbc;

import com.example.springBoot.jpa_and_hibernate_jdbc.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepo {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into course (id, name, author) values (?,?,?);
            """;
    private static String DELETE =
            """
                delete from course where id = ?;
            """;

    private static String SELECT_QUERY =
            """
                select * from course where id = ?;
            """;


    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(DELETE, id);
    }

    public Course findById(long id){
        //Result Set => Bean => Row Mapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);
    }
}
