package com.example.moviesbackend.repository;

import com.example.moviesbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT c FROM Comment c WHERE c.idfilm = :idfilm")
    List<Comment> findCommentaireById_film(Long idfilm);
}