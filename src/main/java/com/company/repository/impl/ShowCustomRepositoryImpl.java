package com.company.repository.impl;

import com.company.model.Show;
import com.company.repository.ShowCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ShowCustomRepositoryImpl implements ShowCustomRepository {
    @Autowired
    private EntityManager em;

    @Override
    public List<Show> getAllShows() {

        Query query= em.createNativeQuery("SELECT s.* " +
                " FROM public.show s  ", Show.class);

        return query.getResultList();

    }
}
