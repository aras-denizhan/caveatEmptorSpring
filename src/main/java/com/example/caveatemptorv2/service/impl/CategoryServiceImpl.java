package com.example.caveatemptorv2.service.impl;

import com.example.caveatemptorv2.dto.SubCategoryDto;
import com.example.caveatemptorv2.model.Category;
import com.example.caveatemptorv2.repository.CategoryRepository;
import com.example.caveatemptorv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        if(categoryRepository.existsById(category.getId())){
            categoryRepository.save(category);
        }
    }

    @Override
    public void addSubCategory(SubCategoryDto subCategoryDto) {
        Category category = categoryRepository.findCategoryByName(subCategoryDto.getParentCategoryName());
        categoryRepository.addSubCategory(subCategoryDto.getName(), category.getId());
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
