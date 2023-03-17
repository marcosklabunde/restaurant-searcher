package com.klabunde.searcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@SpringBootApplication
public class RestaurantSearcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantSearcherApplication.class, args);
	}

}
