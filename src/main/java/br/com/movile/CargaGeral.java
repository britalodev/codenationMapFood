package br.com.movile;

import br.com.movile.customer.repository.CustomerRepository;
import br.com.movile.item.repository.ItemRepository;
import br.com.movile.motoboy.model.Motoboy;
import br.com.movile.motoboy.repository.MotoboyRepository;
import br.com.movile.motoboy.service.MotoboyService;
import br.com.movile.restaurant.model.Restaurant;
import br.com.movile.restaurant.repository.RestaurantRepository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        
        List<GeoResult<Motoboy>> buscaPorProximidade = service.buscaPorProximidade(restaurant,1400.0);                 
        
        StringBuilder builder = new StringBuilder();
        
        buscaPorProximidade.forEach(x -> {        	
        	System.out.println(x);
        	builder.append(x.getContent().toString() + " \n ");        	
        });
        
        return builder.toString() + "\n" + "Carga ok !";
    }

}
