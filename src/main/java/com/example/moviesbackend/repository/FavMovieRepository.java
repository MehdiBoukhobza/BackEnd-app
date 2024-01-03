package com.example.moviesbackend.repository;

import com.example.moviesbackend.model.FavoriteMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavMovieRepository extends JpaRepository<FavoriteMovies, Long> {

    FavoriteMovies findByMovieId(Long movieId);

    List<FavoriteMovies> findByEmail(String email);

    FavoriteMovies findByEmailAndMovieId(String email, Long movieId);
}
