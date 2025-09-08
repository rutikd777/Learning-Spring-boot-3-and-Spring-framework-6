package com.restfulapi.web.restful_Web_services.User;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class userResource {

    private userDaoService service;

    public userResource(userDaoService service) {
        this.service = service;
    }

    //GET-users
    @GetMapping("/users")
    public List<User> retriveAllUser(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id:" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.delete(id);
    }


//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id){
//        User user = service.findOne(id);
//
//        if(user == null){
//            throw new UserNotFoundException("id:" + id);
//        }
//
//        EntityModel<User> entityModel = EntityModel.of(user);
//
//        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());
//        entityModel.add(link.withRel("all-users"));
//
//        return entityModel;
//    }

}
