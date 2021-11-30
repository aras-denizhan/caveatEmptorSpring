package com.example.caveatemptorv2.service.impl;

import com.example.caveatemptorv2.dto.ItemDto;
import com.example.caveatemptorv2.model.Category;
import com.example.caveatemptorv2.model.Item;
import com.example.caveatemptorv2.model.User;
import com.example.caveatemptorv2.repository.ItemRepository;
import com.example.caveatemptorv2.service.CategoryService;
import com.example.caveatemptorv2.service.ItemService;
import com.example.caveatemptorv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    private CategoryService categoryService;
    private UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public Item addNewItem(ItemDto itemDto) {
        Category category = categoryService.getCategoryByName(itemDto.getCategoryName());
        User user = userService.getUserByName(itemDto.getSellerName());
        Item item = new Item(itemDto.getName(),itemDto.getInitialPrice(),itemDto.getAuctionEnd(),
                itemDto.getImages(),category,user);
        category.getItems().add(item);
        user.getSoldItems().add(item);
        return itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) {
        if(itemRepository.existsById(item.getId())){
            itemRepository.save(item);
        }
    }

    @Override
    public boolean deleteItem(Long id) {
        if(itemRepository.existsById(id)){
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.getById(id);
    }

    @Override
    public List<Item> getItemsBySellerId(Long id) {
        return itemRepository.findItemsBySeller(id);
    }

    @Override
    public Item getItemByName(String name) {
        return itemRepository.findItemByName(name);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
