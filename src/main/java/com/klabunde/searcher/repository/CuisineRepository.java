package com.klabunde.searcher.repository;

import com.klabunde.searcher.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository  extends JpaRepository<Cuisine, Long> {
}
