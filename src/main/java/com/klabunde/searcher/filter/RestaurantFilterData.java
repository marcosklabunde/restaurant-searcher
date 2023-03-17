package com.klabunde.searcher.filter;

import com.klabunde.searcher.model.QRestaurant;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.util.Objects;

public class RestaurantFilterData {

    private String restaurantName;

    private Long customerRating;

    private Long distance;

    private Long price;

    private String cuisineName;

    public RestaurantFilterData() {
    }

    public Predicate buildFilter() {
        BooleanBuilder builder = new BooleanBuilder();
        QRestaurant restaurant = QRestaurant.restaurant;

        if (Objects.nonNull(restaurantName) && !restaurantName.isBlank()) {
            builder.and(restaurant.name.contains(restaurantName));
        }

        if (Objects.nonNull(customerRating)) {
            BooleanBuilder rattingBuilder = new BooleanBuilder(restaurant.customerRating.eq(customerRating)
                    .or(restaurant.customerRating.gt(customerRating)));

            builder.and(rattingBuilder);
        }

        if (Objects.nonNull(distance)) {
            BooleanBuilder distanceBuilder = new BooleanBuilder(restaurant.distance.eq(distance)
                    .or(restaurant.distance.lt(distance)));

            builder.and(distanceBuilder);
        }

        if (Objects.nonNull(price)) {
            BooleanBuilder priceBuilder = new BooleanBuilder(restaurant.price.eq(price)
                    .or(restaurant.price.lt(price)));

            builder.and(priceBuilder);
        }

        if (Objects.nonNull(cuisineName) && !cuisineName.isBlank()) {
            builder.and(restaurant.cuisine.name.contains(cuisineName));
        }

        return builder;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Long getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(Long customerRating) {
        this.customerRating = customerRating;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }
}
