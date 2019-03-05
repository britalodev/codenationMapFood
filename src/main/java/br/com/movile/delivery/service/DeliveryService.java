package br.com.movile.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.movile.delivery.model.DeliveryModel;
import br.com.movile.delivery.repository.DeliveryRepository;
import br.com.movile.order.model.Order;

public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	public void addOrder(DeliveryModel delivery, Order order) {
		delivery.addOrder(order);
		deliveryRepository.save(delivery);
	}

}
