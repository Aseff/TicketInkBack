package com.company.controller;

import com.company.model.Cinema;
import com.company.model.Movie;
import com.company.model.Show;
import com.company.repository.MovieRepository;
import com.company.repository.ShowRepository;
import com.company.service.MovieService;
import com.company.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;

    private final ShowService showService;

    public ShowController(ShowService showService) {

        this.showService = showService;
    }

    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> showList = showService.getShows();
        return new ResponseEntity<>(showList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable("id") int id) {
        Show show = showService.findShowById(id);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }


    @PostMapping("/add")
    public  ResponseEntity<Show> addShow(@RequestBody Show show){
        Show newShow = showService.addShow(show);
        return new ResponseEntity<>(newShow, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public  ResponseEntity<Show> updateShow(@RequestBody Show show){
        Show updatedShow = showService.updateShow(show);
        return new ResponseEntity<>(updatedShow, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Show> deleteShow(@PathVariable("id") int id){
        showService.deleteShow(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
