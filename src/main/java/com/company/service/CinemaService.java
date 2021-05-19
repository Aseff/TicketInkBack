package com.company.service;

import com.company.exception.CinemaNotFoundException;
import com.company.model.Cinema;
import com.company.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaService {
    private   CinemaRepository cinemaRepository;

    @Autowired
    private CinemaService(CinemaRepository cinemaRepository){

        this.cinemaRepository=cinemaRepository;
    }

    public List<Cinema> getCinemas() {

        return cinemaRepository.getAllCinemas();
    }

    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Cinema updateCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }

    public Cinema findCinemaById(Long id) {
        return cinemaRepository.findById(id).orElseThrow(() -> new CinemaNotFoundException("Cinema with " + id + " is not found"));
    }

}
