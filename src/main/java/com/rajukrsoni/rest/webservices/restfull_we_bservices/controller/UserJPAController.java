package com.rajukrsoni.rest.webservices.restfull_we_bservices.controller;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.Post;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.UserRequest;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Exception.UserNotFoundException;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.JPARepository.UserRepository;
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
public class UserJPAController {

    private UserRepository userRepository;

    public UserJPAController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<UserRequest> retriveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<UserRequest> retriveAllUsers(@PathVariable int id){
        Optional<UserRequest> userRequestData = userRepository.findById(id);
        if (userRequestData.isEmpty()){
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<UserRequest> entityModel =  EntityModel.of(userRequestData.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());

        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUsers(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePosts(@PathVariable int id){
        Optional<UserRequest> userRequestData = userRepository.findById(id);
        if (userRequestData.isEmpty()){
            throw new UserNotFoundException("id: " + id);
        }
        return userRequestData.get().getPost();
    }


    @PostMapping("/jpa/users")
    public ResponseEntity<UserRequest> createUsers(@Valid @RequestBody UserRequest request){
        UserRequest savedUser = userRepository.save(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
