package br.com.movile.item.controller;

import br.com.movile.item.model.Item;
import br.com.movile.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itens")
public class ItemController {


    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert (@RequestBody Item item){
        itemService.insert(item);
    }
    //Retrieve
    @GetMapping
    public List<Item> findAll (){
        return itemService.findAll();
    }

    @GetMapping("{id}")
    public Item findById (@PathVariable String id){
        return itemService.findById(id);
    }

    //Update

    //Delete



}
