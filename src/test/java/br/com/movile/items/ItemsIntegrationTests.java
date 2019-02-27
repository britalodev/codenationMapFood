package br.com.movile.items;

import br.com.movile.item.model.Item;
import br.com.movile.item.repository.ItemRepository;
import io.restassured.RestAssured;
import io.restassured.mapper.TypeRef;
import jdk.internal.dynalink.linker.LinkerServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemsIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp(){
        RestAssured.port = port;
        itemRepository.deleteAll();
        itemRepository.save(new Item("id0", "description", "restaurant", "restaurantId", "classification", new BigDecimal(100),"addressCity"));
    }

    @Test
    void shouldInsertNewItem(){
        given()
                .contentType("application/json")
                .body(new Item("id", "description", "restaurant", "restaurantId", "classification", new BigDecimal(100),"addressCity"))
                .when()
                .post("mapfood/itens")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void sholdNotInsertItemThatAlreadyExists(){
        given()
                .contentType("application/json")
                .body(new Item("id", "description", "restaurant", "restaurantId", "classification", new BigDecimal(100),"addressCity"))
                .when()
                .post("mapfood/itens")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("message" , equalTo("Item já existe, não é possivel inserir."));

    }

    @Test
    void shouldRetrieveAllItems(){
        List<Item> allitems = given()
                .accept("application/json")
                .when()
                .get("mapfood/itens")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(new TypeRef<List<Item>>() {});


        Assertions.assertEquals(1, allitems.size());
        Assertions.assertAll(
                () -> Assertions.assertEquals("id0", allitems.get(0).getId()),
                () -> Assertions.assertEquals("description", allitems.get(0).getDescription()),
                () -> Assertions.assertEquals("classification", allitems.get(0).getClassification()),
                () -> Assertions.assertEquals(new BigDecimal(100), allitems.get(0).getUnitPrice()),
                () -> Assertions.assertEquals("addressCity", allitems.get(0).getAddressCity())
        );
    }

    @Test
    void shouldFindItemById (){
        Item itemRetrieved = given()
                .accept("application/json")
                .when()
                .get("mapfood/itens/id0")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(Item.class);


        Assertions.assertAll(
                () -> Assertions.assertEquals("id0", itemRetrieved.getId()),
                () -> Assertions.assertEquals("description", itemRetrieved.getDescription()),
                () -> Assertions.assertEquals("classification", itemRetrieved.getClassification()),
                () -> Assertions.assertEquals(new BigDecimal(100), itemRetrieved.getUnitPrice()),
                () -> Assertions.assertEquals("addressCity", itemRetrieved.getAddressCity())
        );
    }

}
