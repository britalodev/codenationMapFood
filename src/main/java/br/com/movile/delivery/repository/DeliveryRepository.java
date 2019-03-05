package br.com.movile.delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.movile.delivery.model.DeliveryModel;

@Repository
public interface DeliveryRepository extends MongoRepository<DeliveryModel, Long> {
}
