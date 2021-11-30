package com.example.caveatemptorv2.repository;

import com.example.caveatemptorv2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Category (name, parent_category_id) VALUES(?1, ?2)", nativeQuery = true)
    void addSubCategory(String name, Long parentCategoryId);

    @Query(value="SELECT * FROM Category WHERE name=?1",nativeQuery = true)
    Category findCategoryByName(String name);
}
