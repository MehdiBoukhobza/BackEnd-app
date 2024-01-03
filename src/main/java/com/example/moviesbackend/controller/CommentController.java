package com.example.moviesbackend.controller;

import com.example.moviesbackend.model.Comment;
import com.example.moviesbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commentaire")
public class CommentController  {
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/commentaires")
    public ResponseEntity<List<Comment>> getAllCommentaire(){
        List<Comment> employees = commentService.findAllCommentaire();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{idfilm}")
    public ResponseEntity<List<Comment>> getEmployeeById(@PathVariable("idfilm") Long idfilm){
        List<Comment> employee= commentService.findCommentaireByIdFilm(idfilm);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Comment> addEmployee(@RequestBody Comment commentaire){
        Comment newemployee= commentService.addCommentaire(commentaire);
        return new ResponseEntity<>(newemployee, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        commentService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}