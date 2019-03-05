package br.com.movile.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.stereotype.Service;

import br.com.movile.customer.model.Customer;
import br.com.movile.delivery.model.DeliveryModel;
import br.com.movile.delivery.repository.DeliveryRepository;
import br.com.movile.exception.model.NoMotoboyAvailableException;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.service.MotoboyService;
import br.com.movile.order.model.Order;
import br.com.movile.order.repository.OrderRepository;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.service.RestaurantService;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private MotoboyService motoboyService;
	@Autowired
	private RestaurantService restaurantService;
//	@Autowired
//	private RestaurantRepository restaurantDAO;

	public void makeAWish(Order order, Restaurant restaurant, Customer customer, double distance) throws NoMotoboyAvailableException  {
		order.setMotoboy(searchBetterMotoboyForDelivery(order, distance));
		order.setDistance(getDistanceCustomer(restaurant, customer));
		
		orderRepository.save(order);
	}

	private Motoboy searchBetterMotoboyForDelivery(Order order, double distance) throws NoMotoboyAvailableException {
		return motoboyService.searchBetterMotoboyForDelivery(order.getRestaurant(), distance);
	}

	private Distance getDistanceCustomer(Restaurant restaurant, Customer customer) {
		return restaurantService.getCustomerDistance(customer, restaurant);
	}
	
	public void addOrder(DeliveryModel delivery, Order order) {
		delivery.addOrder(order);
		deliveryRepository.save(delivery);
	}
}
