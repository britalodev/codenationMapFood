package br.com.movile.restaurant.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "restaurant")
@Getter
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 5856157740319782874L;
	@Id
	@Setter
	private String id;
	private String name;
	private String addressCity;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;
	private String dishDescription;


	public Restaurant(String id, String name, String addressCity, GeoJsonPoint location, String dishDescription) {
		this.id = id;
		this.name = name;
		this.addressCity = addressCity;
		this.location = location;
		this.dishDescription = dishDescription;
	}

	public Restaurant(String id, String name, String addressCity, double latitude, double longitude, String dishDescription) {
		this.id = id;
		this.name = name;
		this.addressCity = addressCity;
		this.location = new GeoJsonPoint(latitude, longitude);
		this.dishDescription = dishDescription;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", addressCity=" + addressCity + ", location=" + location
				+ ", dishDescription=" + dishDescription + "]";
	}
}
