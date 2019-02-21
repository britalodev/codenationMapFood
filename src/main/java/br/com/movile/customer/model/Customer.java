package br.com.movile.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;


@Getter
@Document(collection = "customer")
public class Customer {

	@Id
	private String id;
	private double longitude;
	private double latitude;

	public Customer(String id, double longitude, double latitude) {
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id='" + id + '\'' +
				", longitude=" + longitude +
				", latitude=" + latitude +
				'}';
	}
}