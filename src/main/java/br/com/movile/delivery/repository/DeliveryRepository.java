package br.com.movile.delivery.repository;

import br.com.movile.delivery.model.Delivery;
import br.com.movile.delivery.model.DeliveryStatus;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, String> {

    @Query("{ 'status': ?0, 'windowBegin' : { $lt : ?1 } }")
    List<Delivery> findAllOpened(DeliveryStatus status, LocalDateTime minimalTime);
}
