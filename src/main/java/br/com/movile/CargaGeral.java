package br.com.movile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movile.customer.repository.CustomerRepository;
import br.com.movile.exception.model.NoMotoboyAvailableException;
import br.com.movile.item.repository.ItemRepository;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.repository.MotoboyRepository;
import br.com.movile.motoboy.service.MotoboyService;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;
import lombok.NonNull;

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

	@GetMapping
	public String carga() {
//		Carga carga = new Carga();
//		carga.cargaGeral();
//
//		carga.getMotoboy().stream().forEach(x -> motoDAO.save(x));
//		carga.getClientes().stream().forEach(x -> clienteDAO.save(x));
//		carga.getEstabelecimentos().stream().forEach(x -> estabelecimentoDAO.save(x));
//		carga.getProdutos().stream().forEach(x -> produtoDAO.save(x));

		Restaurant restaurant = estabelecimentoDAO.findAll().get(0);

		Motoboy motoboyForDelivery;
		try {
			motoboyForDelivery = service.searchBetterMotoboyForDelivery(restaurant, 100.0);
			String string = motoboyForDelivery.toString();
			return string + "     " + "Carga ok !";
		} catch (NoMotoboyAvailableException e) {
			System.out.println(e);
		}
		return null;
	}

}
