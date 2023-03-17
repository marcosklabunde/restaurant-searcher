package com.klabunde.searcher.service.impl;

import com.klabunde.searcher.model.Cuisine;
import com.klabunde.searcher.repository.CuisineRepository;
import com.klabunde.searcher.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;

    @Override
    public void save(List<Cuisine> cuisineList) {
        cuisineRepository.saveAll(cuisineList);
    }
}
