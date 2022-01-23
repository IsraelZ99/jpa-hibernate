package com.israel.jpahibernate.inventory.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public Iterable<Item> readAllItems(){
        return itemRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id){
        itemRepository.deleteById(id);
    }

}
