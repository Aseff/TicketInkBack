package com.company.repository;

import com.company.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CinemaRepository extends JpaRepository<Cinema,Long>,CinemaCustomRepository {

}
