package br.com.movile.restaurant.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 5856157740319782874L;
	@Id
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", addressCity=" + addressCity + ", location=" + location
				+ ", dishDescription=" + dishDescription + "]";
	}
}
