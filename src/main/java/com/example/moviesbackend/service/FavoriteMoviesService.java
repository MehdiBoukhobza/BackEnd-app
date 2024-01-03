package com.example.moviesbackend.service;

import com.example.moviesbackend.model.FavoriteMovies;
import com.example.moviesbackend.repository.FavMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FavoriteMoviesService {

    private FavMovieRepository favoriteMoviesRepository;

    @Autowired
    public FavoriteMoviesService(FavMovieRepository favoriteMoviesRepository) {
        this.favoriteMoviesRepository = favoriteMoviesRepository;
    }

    public List<FavoriteMovies> getFavoriteMovie() {
        return favoriteMoviesRepository.findAll();
    }

    public List<FavoriteMovies> getFavoriteMoviesByEmail(String email) {
        return favoriteMoviesRepository.findByEmail(email);
    }

    public List<Long> getFavoriteMovieIdsByEmail(String email) {
        List<FavoriteMovies> favoriteMovies = favoriteMoviesRepository.findByEmail(email);
        return favoriteMovies.stream()
                .map(FavoriteMovies::getMovieId)
                .collect(Collectors.toList());
    }

    public FavoriteMovies addFavoriteMovie(FavoriteMovies favoriteMovies) {
        return favoriteMoviesRepository.save(favoriteMovies);
    }

    public void deleteFavoriteMovie(Long movieId) {
        // Find the FavoriteMovies entity by movieId and delete it if it exists
        FavoriteMovies favoriteMovie = favoriteMoviesRepository.findByMovieId(movieId);
        if (favoriteMovie != null) {
            favoriteMoviesRepository.delete(favoriteMovie);
        } else {
            // Handle event of movieId not real
        }
    }



    public void deleteFavoriteMovieByEmailAndMovieId(String email, Long movieId) {
        FavoriteMovies favoriteMovie = favoriteMoviesRepository.findByEmailAndMovieId(email, movieId);
        if (favoriteMovie != null) {
            favoriteMoviesRepository.delete(favoriteMovie);
        } else {
            // Handle if the favorite movie by email and movieId doesn't exist
        }
    }
}
