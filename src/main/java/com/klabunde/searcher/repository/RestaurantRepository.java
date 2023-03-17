package com.klabunde.searcher.repository;

import com.klabunde.searcher.filter.RestaurantFilterData;
import com.klabunde.searcher.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByFilter(RestaurantFilterData filter);
}
