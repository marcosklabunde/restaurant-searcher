package com.klabunde.searcher.service.impl;

import com.klabunde.searcher.filter.RestaurantFilterData;
import com.klabunde.searcher.model.Restaurant;
import com.klabunde.searcher.repository.RestaurantRepository;
import com.klabunde.searcher.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getRestaurantsByFilter(RestaurantFilterData filter) {
        return restaurantRepository.findByFilter(filter);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public void save(List<Restaurant> restaurantList) {
        restaurantRepository.saveAll(restaurantList);
    }
}
