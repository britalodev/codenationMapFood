package br.com.movile.item.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "item")
@Getter
@Setter
public class Item {

	@Id
	private String id;
	
	@NotNull
	private String description;
	
	private String restaurant;
	
	@NotNull
	private String restaurantId;
	
	private String classification;
	
	@NotNull
	private BigDecimal unitPrice;
	
	private String addressCity;

	public Item(String id, String description, String restaurant, String restaurantId, String classification,
			BigDecimal unitPrice, String addressCity) {
		this.id = id;
		this.description = description;
		this.restaurant = restaurant;
		this.restaurantId = restaurantId;
		this.classification = classification;
		this.unitPrice = unitPrice;
		this.addressCity = addressCity;
	}

	
	@Override
	public String toString() {
		return "Item{" + "id='" + id + '\'' + ", description='" + description + '\'' + ", restaurant='" + restaurant
				+ '\'' + ", restaurantId='" + restaurantId + '\'' + ", classification='" + classification + '\''
				+ ", unitPrice=" + unitPrice + ", addressCity='" + addressCity + '\'' + '}';
	}

}
