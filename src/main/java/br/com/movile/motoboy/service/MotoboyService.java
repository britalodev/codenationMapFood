package br.com.movile.motoboy.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.repository.MotoboyRepository;
import br.com.movile.restaurant.model.Restaurant;

@Service
public class MotoboyService {

    @Autowired
    private MotoboyRepository motoboyRepository;
    @Autowired
    private MongoOperations mongoOperations;
    
    
    public List<GeoResult<Motoboy>> buscaPorProximidade(Restaurant restaurant, Double distance){    	
    	Point point = new Point(restaurant.getLocation().getX(), restaurant.getLocation().getY());    	 	    	   	
    	NearQuery maxDistance = NearQuery.near(point).inKilometers().maxDistance(distance, Metrics.KILOMETERS);    	
    	return mongoOperations.geoNear(maxDistance, Motoboy.class).getContent().stream().limit(5).collect(Collectors.toList());
    }
    
}
