package com.klabunde.searcher.service;

import com.klabunde.searcher.model.Cuisine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CuisineService {

    void save(List<Cuisine> cuisineList);
}
