package com.company.controller;


import com.company.model.Cinema;
import com.company.model.Movie;
import com.company.repository.CinemaRepository;
import com.company.service.CinemaService;
import com.company.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    private final CinemaService cinemaService;


    public CinemaController(CinemaService cinemaService) {

        this.cinemaService = cinemaService;
    }

    @GetMapping("/cinemas")
    public ResponseEntity<List<Cinema>> getCinemas() {
        List<Cinema> cinemaList = cinemaService.getCinemas();
        return new ResponseEntity<>(cinemaList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable("id") Long id) {
        Cinema cinema = cinemaService.findCinemaById(id);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema){
        Cinema newCinema1 = cinemaService.addCinema(cinema);
        return new ResponseEntity<>(newCinema1, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public  ResponseEntity<Cinema> updateCinema(@RequestBody Cinema cinema){
        Cinema updatedCinema = cinemaService.updateCinema(cinema);
        return new ResponseEntity<>(updatedCinema, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Cinema> deleteCinema(@PathVariable("id") Long id){
        cinemaService.deleteCinema(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
