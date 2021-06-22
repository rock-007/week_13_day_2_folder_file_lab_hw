package com.folderlab.lab.controllers;

import com.folderlab.lab.models.User;
import com.folderlab.lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping (value = "/users")
    public List<User> getAllUsers(){
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

}
