package com.company.repository;

import com.company.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository  extends JpaRepository<Show, Integer> {
}
