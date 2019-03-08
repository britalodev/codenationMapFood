package br.com.movile.order.model;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
    @Setter
    private ObjectId id;

    private Customer customer;
    private LocalDateTime date;
    private Restaurant restaurant;
    private List<Item> items;
    @Setter
    private OrderStatus status;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", date=" + date +
                ", restaurant=" + restaurant +
                ", items=" + items +
                ", status=" + status +
                '}';
    }
}
