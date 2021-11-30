package com.example.caveatemptorv2.service;

import com.example.caveatemptorv2.dto.ItemDto;
import com.example.caveatemptorv2.model.Item;

import java.util.List;

public interface ItemService {
    public Item addNewItem(ItemDto itemDto);
    public void updateItem(Item item);
    public boolean deleteItem(Long id);
    public Item getItemById(Long id);
    public List<Item> getItemsBySellerId(Long id);
    public Item getItemByName(String name);
    public List<Item> getAllItems();
}
