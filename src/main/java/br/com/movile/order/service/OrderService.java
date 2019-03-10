package br.com.movile.order.service;

import static br.com.movile.order.model.OrderStatus.CANCELLED;
import static br.com.movile.order.model.OrderStatus.OPENED;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import br.com.movile.customer.model.Customer;
import br.com.movile.customer.repository.CustomerRepository;
import br.com.movile.item.model.Item;
import br.com.movile.item.repository.ItemRepository;
import br.com.movile.order.model.Order;
import br.com.movile.order.model.OrderStatus;
import br.com.movile.order.repository.OrderRepository;
import br.com.movile.restaurant.repository.RestaurantRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	private final RestaurantRepository restaurantRepository;

	private final CustomerRepository customerRepository;

	private final ItemRepository itemRepository;

	private final MongoOperations mongoOperations;

	private boolean close;
	
	public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository,
			CustomerRepository customerRepository, ItemRepository itemRepository, MongoOperations mongoOperations) {
		this.orderRepository = orderRepository;
		this.restaurantRepository = restaurantRepository;
		this.customerRepository = customerRepository;
		this.itemRepository = itemRepository;
		this.mongoOperations = mongoOperations;
	}

	public Order save(Order order) {
		Optional customer = customerRepository.findById(order.getCustomer().getId());
		Optional restaurant = restaurantRepository.findById(order.getRestaurant().getId());

		List<String> ids = order.getItems().stream().map(Item::getId).collect(Collectors.toList());
		Iterable<Item> findAllById = itemRepository.findAllById(ids);

		if (findAllById == null || StreamSupport.stream(findAllById.spliterator(), false).count() != ids.size()) {
			throw new NoSuchElementException("Item(s) inválido(s) ou não encontrado(s)!");
		}

		if (!customer.isPresent()) {
			throw new NoSuchElementException("Usuário inválido e/ou não encontrado!");
		}

		if (!restaurant.isPresent()) {
			throw new NoSuchElementException("Restaurante inválido e/ou não encontrado!");
		}

		order.setStatus(OPENED);

		return orderRepository.save(order);
	}

	public Order getOrder(String orderId) {
		try {
			new ObjectId(orderId);
		} catch (IllegalArgumentException ile) {
			throw new IllegalArgumentException("ObjectId fora do padrão!", ile);
		}
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new NoSuchElementException("Pedido não encontrado!"));
	}

	public void delete(String orderId) {

		Optional<Order> order = orderRepository.findById(orderId);

		if (!order.isPresent()) {
			throw new IllegalArgumentException("Pedido não encontrado!");
		}

		if (order.get().getStatus() == CANCELLED) {
			throw new IllegalArgumentException("Pedido já cancelado!");
		}

		order.get().setStatus(CANCELLED);

		orderRepository.save(order.get());
	}

	public Page<Order> getOrders(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	public void changeStatus(String orderId, OrderStatus cancelled) {
		// TODO Auto-generated method stub

	}

	public boolean closeEnough(Order order1, Order order2, double distanciaMaxima) {

		close = false;

		Point point1 = new Point(order1.getCustomer().getLocalizacao());
		NearQuery maxDistance = NearQuery.near(point1).inKilometers().maxDistance(distanciaMaxima);

		GeoResults<Customer> geoNear = mongoOperations.geoNear(maxDistance, Customer.class);

		geoNear.forEach(x -> {
			String id = x.getContent().getId();
			if (id.equalsIgnoreCase(order2.getCustomer().getId())) {
				close = true;
			}
		});

		return close;
	}
}
