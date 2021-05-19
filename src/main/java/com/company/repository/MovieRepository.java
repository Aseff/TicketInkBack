package com.company.repository;

import com.company.model.Movie;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> ,MovieCustomRepository {
    Optional<Movie> findUserById(int id);

    void deleteMovieById(int id);



}
