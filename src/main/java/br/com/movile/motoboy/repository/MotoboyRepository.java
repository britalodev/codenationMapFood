package br.com.movile.motoboy.repository;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.movile.motoboy.model.Motoboy;

@Repository
public interface MotoboyRepository extends MongoRepository<Motoboy, String> {
	

	void findByLocationNear(Point point, Distance distance);
}