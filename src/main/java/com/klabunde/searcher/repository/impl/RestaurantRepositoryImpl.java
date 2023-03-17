package com.klabunde.searcher.repository.impl;

import com.klabunde.searcher.filter.RestaurantFilterData;
import com.klabunde.searcher.model.QCuisine;
import com.klabunde.searcher.model.QRestaurant;
import com.klabunde.searcher.model.Restaurant;
import com.klabunde.searcher.repository.RestaurantRepository;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl extends SimpleJpaRepository<Restaurant, Long> implements RestaurantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public RestaurantRepositoryImpl(EntityManager entityManager) {
        super(Restaurant.class, entityManager);
    }

    @Override
    public List<Restaurant> findByFilter(RestaurantFilterData filter) {
        QRestaurant restaurant = QRestaurant.restaurant;
        QCuisine cuisine = QCuisine.cuisine;

        JPAQuery<Restaurant> query = new JPAQuery<>(entityManager);
        return query.select(restaurant)
                .from(restaurant)
                .leftJoin(cuisine)
                .on(restaurant.cuisine.id.eq(cuisine.id))
                .where(filter.buildFilter())
                .orderBy(restaurant.distance.asc())
                .orderBy(restaurant.customerRating.desc())
                .orderBy(restaurant.price.asc())
                .orderBy(restaurant.name.asc())
                .limit(5)
                .fetch();
    }
}
