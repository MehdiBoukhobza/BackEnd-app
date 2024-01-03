package com.example.moviesbackend.repository;

import com.example.moviesbackend.model.Comment;
import com.example.moviesbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email =: email AND u.password =: password")
    User findUserByEmailAndPassword(String email, String password);
}
