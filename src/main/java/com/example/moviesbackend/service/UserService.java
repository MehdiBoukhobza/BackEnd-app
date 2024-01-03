package com.example.moviesbackend.service;

import com.example.moviesbackend.model.Comment;
import com.example.moviesbackend.model.User;
import com.example.moviesbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(User user){
        return userRepo.save(user);
    }

    public User findUserByEmailAndPassword(String email, String password) {
        return userRepo.findUserByEmailAndPassword(email, password);
    }
}
