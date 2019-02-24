package br.com.movile.restaurant.controller;


import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;
import io.restassured.RestAssured;
import io.restassured.mapper.TypeRef;



@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestaurantIntegrationTest {
    
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }


    @Test
    void getRestaurants(@Autowired final RestaurantRepository restaurantRepository)  {
    	
        restaurantRepository.save(new Restaurant( "1", "McDonalds", "Rua 123", new GeoJsonPoint(50.00,50.00), "Lanches"));

        List<Restaurant> restaurants = given()
                .accept("application/json")
                .when()
                .get("mapfood/restaurants")
                .then()
                .extract()
                .as(new TypeRef<List<Restaurant>>() {});

        Assertions.assertEquals(1, restaurants.size());
        Assertions.assertAll(
                () -> Assertions.assertEquals("1", restaurants.get(0).getId()),
                () -> Assertions.assertEquals("McDonalds", restaurants.get(0).getName()),
                () -> Assertions.assertEquals("Rua 123", restaurants.get(0).getAddressCity()),
                () -> Assertions.assertEquals(50.00d, restaurants.get(0).getLocation().getX()),
                () -> Assertions.assertEquals(50.00d, restaurants.get(0).getLocation().getY()),
                () -> Assertions.assertEquals("Lanches", restaurants.get(0).getDishDescription())
        );
    }

}