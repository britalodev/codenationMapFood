package br.com.movile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movile.customer.repository.CustomerRepository;
import br.com.movile.item.model.Item;
import br.com.movile.item.repository.ItemRepository;
import br.com.movile.motoboy.repository.MotoboyRepository;
import br.com.movile.motoboy.service.MotoboyService;
import br.com.movile.order.model.Order;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;

@RestController
@RequestMapping("carga")
public class CargaGeral {

	@Autowired
	private MotoboyRepository motoDAO;
	@Autowired
	private CustomerRepository clienteDAO;
	@Autowired
	private RestaurantRepository estabelecimentoDAO;
	@Autowired
	private ItemRepository produtoDAO;
	@Autowired
	private MotoboyService service;

	@GetMapping("/{id}")
	public String carga(@PathVariable String id) {
		Carga carga = new Carga();
		carga.cargaGeral();

		carga.getMotoboy().stream().forEach(x -> motoDAO.save(x));
		carga.getClientes().stream().forEach(x -> clienteDAO.save(x));
		carga.getEstabelecimentos().stream().forEach(x -> estabelecimentoDAO.save(x));
		carga.getProdutos().stream().forEach(x -> produtoDAO.save(x));

		Restaurant restaurant = estabelecimentoDAO.findById(id).get();

		System.err.println(restaurant);

		

		StringBuilder builder = new StringBuilder();

		List<String> ids = new ArrayList<>();

		Order order = new Order();
		
		
		Iterable<Item> findAllById = produtoDAO.findAllById(order.getItems().stream().map(x -> x.getId()).collect(Collectors.toList()));
		
		
		


		return builder.toString() + "\n" + "Carga ok !";
	}

}
