package br.com.movile.motoboy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.movile.motoboy.model.MotoBoy;

public interface MotoBoyRepository extends MongoRepository<MotoBoy, String> {
}