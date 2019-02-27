package br.com.movile.items;

import br.com.movile.item.repository.ItemRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

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
    }

}
