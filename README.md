# Restaurant searcher project
For this project I used: Java 17, Spring Boot 3.0.4, Spring Data, Hibernate, Query DSL, H2 and ReactJS.
The goal of the project was read CSV files, save their data on the H2 database, and then filter this data 
based on some parameters to return the best matching restaurant.

## Project execution (Default)
- Generate project resources (to generate the Q classes from Query DSL);
- Run a "mvn clean install";
- Run RestaurantSearcherApplication.java to start Spring application;
- In the terminal, go to frontend folder (cd src/main/frontend) and execute the command "yarn install";
- Then, in the same folder, execute the command "yarn start" to start the ReactJS application.

## Project execution (Docker)
- Generate project resources (to generate the Q classes from Query DSL);
- Run a "mvn clean install";
- Open the terminal on the project root folder;
- Run the command docker-compose up.

## Default ports
- Frontend is available on port 3000;
- Backend is available on port 8080.

## Endpoints

GET: /restaurants - Get all restaurants
<br>
GET: /restaurants/filter - Get restaurants by filter

## H2 Database

As it is a test project, I chose to use an in-memory relational database, avoiding the need to install
some database for the execution of the project. To access the project database:
- Access: 127.0.0.1:8080/h2-ui
- JDBC URL: jdbc:h2:mem:searcherdb
- Username: sa
- Password: 123

## Future improvements for the project

- Allow user to change de ordenation of the results;
- Allow user to change the maximum amount of results (current fixed to five);
- Generify the FilterData class to make it easy to expand to more entity types.