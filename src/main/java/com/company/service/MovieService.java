package com.company.service;

import com.company.exception.MovieNotFoundException;
import com.company.exception.UserNotFoundException;
import com.company.model.Movie;
import com.company.model.User;
import com.company.repository.MovieRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository ) {

        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {

        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteMovieById(id);
    }

    public Movie findMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie with " + id + " is not found"));
    }

}
