package com.example.caveatemptorv2.repository;

import com.example.caveatemptorv2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM item WHERE name = ?1", nativeQuery = true)
    Item findItemByName(String name);

    @Query(value = "SELECT * FROM item WHERE seller_id = ?1", nativeQuery = true)
    List<Item> findItemsBySeller(Long sellerId);
}
