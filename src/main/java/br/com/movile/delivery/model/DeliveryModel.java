package br.com.movile.delivery.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.movile.order.model.Order;
import br.com.movile.restaurant.model.Restaurant;
import lombok.Getter;

@Getter
@Document(collection = "delivery")
public class DeliveryModel {

	@Id
	private Long id;
	private List<Order> orders;
	private LocalDateTime time;
	private Restaurant restaurant;
	
	public void addOrder(Order order) {
		if (orders.size() < 5) {
			orders.add(order);	
			orderByDistance();
		}
	}

	public int verifyQuantityOrders() {
		return orders.size();
	}
	
	private void orderByDistance(){		
		Collections.sort(orders, Comparator.comparing(Order::getDistance));
	}
	
}
