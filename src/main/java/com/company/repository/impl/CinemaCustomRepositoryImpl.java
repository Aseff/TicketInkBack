package com.company.repository.impl;

import com.company.model.Cinema;
import com.company.model.Movie;
import com.company.repository.CinemaCustomRepository;
import com.company.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CinemaCustomRepositoryImpl implements CinemaCustomRepository {
    @Autowired
    private EntityManager em;

    @Override
    public List<Cinema> getAllCinemas() {

        Query query= em.createNativeQuery("SELECT c.* " +
                " FROM public.cinema_Hall c  ", Cinema.class);

        return query.getResultList();

    }
}
