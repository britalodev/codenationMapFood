package br.com.movile.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.movile.exception.model.dto.ElementAlreadyExistException;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.service.RestaurantService;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Retrieval
    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable String id) {
        return restaurantService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody Restaurant restaurant ) throws ElementAlreadyExistException {
            restaurantService.insert(restaurant);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void save (@PathVariable("id") String id , @RequestBody Restaurant restaurant ){
        restaurant.setId(id);
        restaurantService.save(restaurant);
    }

    //Delete
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById (@PathVariable("id") String id){
        restaurantService.deleteById(id);
    }

}
