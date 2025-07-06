package com.rajukrsoni.rest.webservices.restfull_we_bservices.controller;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dao.UserDaoService;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.UserRequest;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<UserRequest> retriveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserRequest retriveAllUsers(@PathVariable int id){
        UserRequest userRequestData = userDaoService.findOne(id);
        if (userRequestData == null){
            throw new UserNotFoundException("id: " + id);
        }
        return userRequestData;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id){
        userDaoService.deleteUsers(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserRequest> createUsers(@Valid @RequestBody UserRequest request){
        UserRequest savedUser = userDaoService.save(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
