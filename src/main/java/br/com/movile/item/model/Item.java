package br.com.movile.item.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "item")
@Getter
@Setter
public class Item {

	@Id
	private String id;

	@NotNull
	private String description;

	private String restaurant;

	@NotNull
	private String restaurantId;

	private String classification;

	@NotNull
	private BigDecimal unitPrice;

	private String addressCity;

}
