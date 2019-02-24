package br.com.movile.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
//	@Autowired
//	private MotoboyRepository motoboyRepository;

	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	public List<Motoboy> getNearMotoboy(Restaurant restaurant) {

		return null;
	}
}
