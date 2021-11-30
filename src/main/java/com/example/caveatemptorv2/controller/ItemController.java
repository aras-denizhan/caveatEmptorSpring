package com.example.caveatemptorv2.controller;

import com.example.caveatemptorv2.dto.ItemDto;
import com.example.caveatemptorv2.model.Item;
import com.example.caveatemptorv2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping
    public Item addNewItem(@RequestBody @Valid ItemDto itemDto) {
        Objects.requireNonNull(itemDto,"User cannot be null.");
        return itemService.addNewItem(itemDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/user/{id}")
    public List<Item> getItemsBySellerId(@PathVariable Long id) {
        return itemService.getItemsBySellerId(id);
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
