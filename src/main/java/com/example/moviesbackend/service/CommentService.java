package com.example.moviesbackend.service;

import com.example.moviesbackend.model.Comment;
import com.example.moviesbackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepo;
    @Autowired
    public CommentService(CommentRepository commentaireRepo) {
        this.commentRepo = commentaireRepo;
    }

    public Comment addCommentaire(Comment commentaire){
        return commentRepo.save(commentaire);
    }

    public List<Comment> findAllCommentaire(){
        return commentRepo.findAll();
    }

    public void deleteEmployee(Long id){
        commentRepo.deleteById(id);
    }

    public List<Comment> findCommentaireByIdFilm(Long idfilm){
        return (List<Comment>) commentRepo.findCommentaireById_film(idfilm);
    }
}
