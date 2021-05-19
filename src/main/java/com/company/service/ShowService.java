package com.company.service;


import com.company.exception.ShowNotFoundException;
import com.company.model.Show;
import com.company.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShowService {
    private ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository ) {

        this.showRepository = showRepository;
    }

    public List<Show> getShows() {

        return showRepository.findAll();
    }

    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public Show updateShow(Show show) {
        return showRepository.save(show);
    }

    public void deleteShow(int id) {
        showRepository.deleteById(id);
    }

    public Show findShowById(int id) {
        return showRepository.findById(id).orElseThrow(() -> new ShowNotFoundException("Show with " + id + " is not found"));
    }

}
