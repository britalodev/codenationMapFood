package br.com.movile.order.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.movile.customer.model.Customer;
import br.com.movile.item.model.Item;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.restaurant.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "order")
@Getter
public class Order {

	@Id
	private long id;
	@Setter
	private List<Item> items;
	private Customer customer;
	private Restaurant restaurant;
	@Setter
	private Motoboy motoboy;
	@Setter
	private LocalDateTime date;
	@Setter
	private Distance distance;

	@Override
	public String toString() {
		return "Order [id=" + id + 
				", items=" + items + 
				", customer=" + customer + 
				", restaurant=" + restaurant
				+ ", motoboy=" + motoboy + 
				", date=" + date + 
				"]";
	}
}
