package com.restfulapi.web.restful_Web_services.JPA;
import com.restfulapi.web.restful_Web_services.User.Post;
import com.restfulapi.web.restful_Web_services.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Post_Repository extends JpaRepository<Post, Integer> {

}
