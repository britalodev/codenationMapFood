package br.com.movile.motoboy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import br.com.movile.exception.model.NoMotoboyAvailableException;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.repository.MotoboyRepository;
import br.com.movile.restaurant.model.Restaurant;

@Service
public class MotoboyService {

	@Autowired
	private MotoboyRepository motoboyRepository;
	@Autowired
	private MongoOperations mongoOperations;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Motoboy searchBetterMotoboyForDelivery(Restaurant restaurant, Double distance) throws NoMotoboyAvailableException {

		Point point = new Point(restaurant.getLocation().getX(), restaurant.getLocation().getY());
		NearQuery maxDistance = NearQuery.near(point).inKilometers().maxDistance(distance, Metrics.KILOMETERS);
		GeoResults<Motoboy> geoNear = mongoOperations.geoNear(maxDistance, Motoboy.class);
		if(geoNear.getContent().isEmpty()) {
			throw new NoMotoboyAvailableException("No motoboy found nearby!");
		} else
			return geoNear.getContent().get(0).getContent();
	}

}
