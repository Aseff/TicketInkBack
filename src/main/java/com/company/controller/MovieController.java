package com.company.controller;

import com.company.model.Movie;
import com.company.repository.MovieRepository;
import com.company.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    private final MovieService movieService;

    public MovieController(MovieService movieService) {

        this.movieService = movieService;
    }

    @CrossOrigin(origins = "http://localhost:4401/movie")
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movieList = movieRepository.getMoviesCustom();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id) {
        Movie movie = movieService.findMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


    @PostMapping("/add")
    public  ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie newMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public  ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        Movie updatedMovie = movieService.updateMovie(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Movie> deleteMovie(@PathVariable("id") int id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
