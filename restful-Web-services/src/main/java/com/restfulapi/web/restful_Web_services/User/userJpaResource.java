package com.restfulapi.web.restful_Web_services.User;

import com.restfulapi.web.restful_Web_services.JPA.Post_Repository;
import com.restfulapi.web.restful_Web_services.JPA.User_Repository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class userJpaResource {

    private userDaoService service;
    private User_Repository repository;
    private Post_Repository postRepository;

    public userJpaResource(User_Repository repository,Post_Repository postRepository ) {
        this.repository = repository;
        this.postRepository =  postRepository;
    }

    //GET-users
    @GetMapping("/jpa/users")
    public List<User> retriveAllUser(){
        return repository.findAll();
    }
//
//    @GetMapping("/jpa/users/{id}")
//    public User retriveUser(@PathVariable int id){
//        User user = service.findOne(id);
//        if(user == null){
//            throw new UserNotFoundException("id:" + id);
//        }
//        return user;
//    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveUserPost(@PathVariable int id){

        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }

        return user.get().getPosts();
    }


    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){

        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }




    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id,@Valid @RequestBody Post post){

        Optional<User> user = repository.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }

        post.setUser(user.get()); //getting and setting the value for post for that specific user

        Post savePost =  postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
