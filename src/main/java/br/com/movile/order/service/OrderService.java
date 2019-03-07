package br.com.movile.order.service;

import br.com.movile.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movile.exception.model.NoMotoboyAvailableException;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.service.MotoboyService;
import br.com.movile.order.model.Order;
import br.com.movile.order.repository.OrderRepository;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;

@Service
public class OrderService {

    
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private MotoboyService motoboyService;
	@Autowired
	private RestaurantRepository restaurantDAO;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }
	public void makeAWish(Order order) throws NoMotoboyAvailableException  {
		Restaurant restaurant = order.getRestaurant();
		Double distance = 10.00;
		Motoboy searchBetterMotoboyForDelivery = motoboyService.searchBetterMotoboyForDelivery(restaurant, distance);
	}
}
