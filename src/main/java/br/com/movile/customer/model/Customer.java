package br.com.movile.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Document(collection = "customer")
public class Customer {

	@Id
	private String id;
	@Setter
	private GeoJsonPoint location;

	public Customer(String id, GeoJsonPoint location) {
		this.id = id;
		this.location = location;
	}
}
