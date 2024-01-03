package com.example.moviesbackend.controller;

import com.example.moviesbackend.model.FavoriteMovies;
import com.example.moviesbackend.service.FavoriteMoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FavoriteMoviesController {
    private final FavoriteMoviesService favoriteMoviesService;

    public FavoriteMoviesController(FavoriteMoviesService favoriteMoviesService) {
        this.favoriteMoviesService = favoriteMoviesService;
    }

    @GetMapping("/favorite/{email}")
    public ResponseEntity<List<FavoriteMovies>> getFavoriteMoviesByEmail(@PathVariable("email") String email) {
        List<FavoriteMovies> favoriteMoviesByEmail = favoriteMoviesService.getFavoriteMoviesByEmail(email);
        return ResponseEntity.ok(favoriteMoviesByEmail);
    }



    @PostMapping("/add/{movieId}/{email}")
    public ResponseEntity<?> addFavoriteMovieByEmail(@PathVariable("movieId") Long movieId,
                                                     @PathVariable("email") String email) {
        FavoriteMovies favoriteMovie = new FavoriteMovies();
        favoriteMovie.setMovieId(movieId);
        favoriteMovie.setEmail(email);

        favoriteMoviesService.addFavoriteMovie(favoriteMovie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{movieId}/{email}")
    public ResponseEntity<?> deleteFavoriteMovieByEmail(@PathVariable("movieId") Long id,
                                                        @PathVariable("email") String email) {
        favoriteMoviesService.deleteFavoriteMovieByEmailAndMovieId(email, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/favorite")
    public ResponseEntity<List<FavoriteMovies>> getFavoriteMovieIds() {
        List<FavoriteMovies> favoriteMovieIds = favoriteMoviesService.getFavoriteMovie();
        return ResponseEntity.ok(favoriteMovieIds);
    }

    @PostMapping("/add/{movieId}")
    public ResponseEntity<?> addFavoriteMovie(@RequestBody FavoriteMovies favoriteMovies,
                                              @PathVariable("movieId") Long movieId) {
        favoriteMovies.setMovieId(movieId);
        favoriteMoviesService.addFavoriteMovie(favoriteMovies);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFavoriteMovie(@PathVariable("id") Long id) {
        favoriteMoviesService.deleteFavoriteMovie(id);
        return ResponseEntity.ok().build();
    }

}
