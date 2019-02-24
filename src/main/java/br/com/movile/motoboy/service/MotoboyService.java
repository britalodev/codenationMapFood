package br.com.movile.motoboy.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.geo.Point;

import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.repository.MotoboyRepository;
import br.com.movile.restaurant.model.Restaurant;

@Service
public class MotoboyService {

    @Autowired
    private MotoboyRepository motoboyRepository;
    @Autowired
    private MongoOperations mongoOperations;
    
    
    public List<Motoboy> buscaPorProximidade(Restaurant restaurant, double distance){
    	
    	Point point = new Point(restaurant.getLocation().getX(), restaurant.getLocation().getY());
    	
    	Distance distanceKm = new Distance(distance, Metrics.KILOMETERS);
    	
    	Circle area = new Circle(point, distanceKm);
    	
    	Query query = new Query();
    	query.addCriteria(Criteria.where("location").withinSphere(area)).skip(1).limit(5);
    	
    	return mongoOperations.find(query, Motoboy.class);
    }
    
}
