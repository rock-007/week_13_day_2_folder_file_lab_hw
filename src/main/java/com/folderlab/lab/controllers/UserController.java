package com.folderlab.lab.controllers;

import com.folderlab.lab.models.User;
import com.folderlab.lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping (value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        System.out.println(userRepository.findAll());
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping (value = "/users/{id}")
    public ResponseEntity  getUser(@PathVariable Long id){

         return new ResponseEntity<>(userRepository.findById(id),HttpStatus.OK);
    }



}
