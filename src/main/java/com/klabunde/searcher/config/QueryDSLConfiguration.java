package com.klabunde.searcher.config;

import com.klabunde.searcher.model.Cuisine;
import com.klabunde.searcher.model.Restaurant;
import com.klabunde.searcher.service.CsvParserService;
import com.klabunde.searcher.service.CuisineService;
import com.klabunde.searcher.service.RestaurantService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.InputStream;
import java.util.List;

@Configuration
@EnableJpaRepositories(basePackages = "com.klabunde.searcher")
public class QueryDSLConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CsvParserService csvParserService;

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private RestaurantService restaurantService;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @PostConstruct
    public void initializeDatabase() throws Exception {
        InputStream cuisinesStream = getClass().getResourceAsStream("/csv/cuisines.csv");
        List<Cuisine> cuisineList = csvParserService.parseToList(cuisinesStream, Cuisine.class);
        cuisineService.save(cuisineList);

        InputStream restaurantsStream = getClass().getResourceAsStream("/csv/restaurants.csv");
        List<Restaurant> restaurantList = csvParserService.parseToList(restaurantsStream, Restaurant.class);
        restaurantService.save(restaurantList);
    }
}