package com.klabunde.searcher.service;

import com.klabunde.searcher.filter.RestaurantFilterData;
import com.klabunde.searcher.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    List<Restaurant> getRestaurantsByFilter(RestaurantFilterData filter);

    List<Restaurant> getAllRestaurants();

    void save(List<Restaurant> restaurantList);
}
