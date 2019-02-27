package br.com.movile.item.service;

import br.com.movile.item.model.Item;
import br.com.movile.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void insert(Item item) {
        itemRepository.insert(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(String id) {
        return itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Item não existe na base de dados"));
    }
}
