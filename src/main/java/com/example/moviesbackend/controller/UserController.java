package com.example.moviesbackend.controller;


import com.example.moviesbackend.model.User;
import com.example.moviesbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {
    private UserService userService;

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        User user = userService.findUserByEmailAndPassword(email, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PostMapping("/signup/{email}/{password}/{username}")
//    public ResponseEntity<User> registerUser(@RequestBody User commentaire) {
//        User user = userService.addCommentaire(commentaire);
//        return new ResponseEntity<>(newemployee, HttpStatus.CREATED);
//    }
}
