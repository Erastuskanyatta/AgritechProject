package com.example.agritech.WebApp.Services;

import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Model.Products;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public  class CategoryServices {

    @Autowired
    public  final CategoryRepo categoryRepo;

    public CategoryServices(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }



    public List<Category> getCategoryByCategoryName(String categoryName) {
        return categoryRepo.getCategoriesByCategoryName(categoryName);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepo.deleteById(categoryId);
    }




}

