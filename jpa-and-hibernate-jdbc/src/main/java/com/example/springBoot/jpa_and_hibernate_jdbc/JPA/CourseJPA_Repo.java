package com.example.springBoot.jpa_and_hibernate_jdbc.JPA;
import com.example.springBoot.jpa_and_hibernate_jdbc.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPA_Repo {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){
        Course delCourse = entityManager.find(Course.class, id);
        entityManager.remove(delCourse);
    }
}
