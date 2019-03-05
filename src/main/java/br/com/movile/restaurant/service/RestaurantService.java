package br.com.movile.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import br.com.movile.customer.model.Customer;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
//	@Autowired
//	private MotoboyRepository motoboyRepository;
	@Autowired
	private MongoOperations mongoOperations;

	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	public List<Motoboy> getNearMotoboy(Restaurant restaurant) {

		return null;
	}

	public Distance getCustomerDistance(Customer customer, Restaurant restaurant) {

		Point point = new Point(restaurant.getLocation().getX(), restaurant.getLocation().getY());

		NearQuery distanceInKilometers = NearQuery.near(point).inKilometers();

		GeoResults<Restaurant> geoNear = mongoOperations.geoNear(distanceInKilometers, Restaurant.class);

		return geoNear.getContent().get(0).getDistance().in(Metrics.KILOMETERS);
	}

}
