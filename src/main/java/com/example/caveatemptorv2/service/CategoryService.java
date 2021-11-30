package com.example.caveatemptorv2.service;

import com.example.caveatemptorv2.dto.SubCategoryDto;
import com.example.caveatemptorv2.model.Category;

import java.util.List;

public interface CategoryService {
    public Category addNewCategory(Category category);
    public void updateCategory(Category category);
    public void addSubCategory(SubCategoryDto subCategoryDto);
    public boolean deleteCategory(Long id);
    public Category getCategoryById(Long id);
    public Category getCategoryByName(String name);
    public List<Category> getAllCategories();
}
