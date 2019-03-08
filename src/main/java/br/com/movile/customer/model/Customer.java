
package br.com.movile.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "customer")
public class Customer {

	@Id
	private String id;

	@Setter
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;

	public Customer(String id, double latitude, double longitude){
	    this.id = id;
	    this.location = new GeoJsonPoint(latitude, longitude);
    }

	@Override
	public String toString() {
		return "Customer{" + "id='" + id + '\'' + '}';
	}

}
