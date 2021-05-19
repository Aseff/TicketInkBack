package com.company.repository.impl;

import com.company.model.Movie;
import com.company.repository.MovieCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieCustomRepositoryImpl implements MovieCustomRepository {
    @Autowired
    private EntityManager em;

    @Override
    public List<Movie> getMoviesCustom() {

        Query query= em.createNativeQuery("SELECT m.* " +
                " FROM public.movie m  ", Movie.class);

        return query.getResultList();

    }
}
