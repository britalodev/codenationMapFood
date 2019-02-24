package br.com.movile.motoboy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Document(collection = "motoboy")
public class Motoboy {

	@Id
	private String id;
	@Setter
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;
	
	public Motoboy(String id, GeoJsonPoint location) {
		this.id = id;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Motoboy [id=" + id + ", location=" + location + "]";
	}

}
