package com.example.caveatemptorv2.controller;

import com.example.caveatemptorv2.dto.SubCategoryDto;
import com.example.caveatemptorv2.model.Category;
import com.example.caveatemptorv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addNewCategory(@RequestBody @Valid Category category){
        Objects.requireNonNull(category,"Category cannot be null.");
        return categoryService.addNewCategory(category);
    }

    @PostMapping("/sub")
    public void addSubCategory(@RequestBody @Valid SubCategoryDto subCategoryDto){
        Objects.requireNonNull(subCategoryDto,"Category cannot be null.");
        categoryService.addSubCategory(subCategoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }

    @GetMapping("{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
