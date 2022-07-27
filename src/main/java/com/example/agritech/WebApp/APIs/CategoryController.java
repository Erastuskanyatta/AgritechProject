package com.example.agritech.WebApp.APIs;
import com.example.agritech.WebApp.DTO.CategoryDao;
import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import com.example.agritech.WebApp.Services.CategoryServices;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
   public CategoryRepo categoryRepo;

    public CategoryDao categoryDto;
    public Category category;

    public final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {

        this.categoryServices = categoryServices;
    }

    //creating a new category
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        Map<String, Object> AddCategory = new HashMap<>();
        Category createCategory = categoryServices.createCategory(category);
        AddCategory.put("status_code", HttpStatus.CREATED.value());
        AddCategory.put("message", "Category 🛒 added successfully 🧨 🎊 🎇 !");
        AddCategory.put("data", createCategory);
        AddCategory.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return new ResponseEntity<>(AddCategory, HttpStatus.CREATED);
    }

    // listing All Categories
    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<?> gettingAllCategories(){
        Map<String, Object> list = new HashMap<>();
        List<Category> allCategories =  categoryRepo.findAll();

        list.put("Status_code" , HttpStatus.CREATED.value());
        list.put("Message", "Categories!");
        list.put("data", allCategories);
        list.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return  new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    //listing Categories by type
    @ResponseBody
    @GetMapping("/Category/{categoryName}")
    public Map<String, Object> ViewProduct(@PathVariable String categoryName) {
        Map<String, Object> ListingCategory = new HashMap<>();
        List <Category> Category = categoryServices.getCategoryByCategoryName(categoryName);
        ListingCategory .put("Message", "Success!!");
        ListingCategory .put("Status_code", HttpStatus.CREATED.value());
        ListingCategory .put("Data", Category);
        ListingCategory .put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return ListingCategory ;
    }

    //deleting a product
    @ResponseBody
    @DeleteMapping("{categoryId}")
    public  Map<String,Object> deleteCategory(@PathVariable("categoryId") Long categoryId){
        Map<String, Object> deletingCategory = new HashMap<>();
        categoryServices.deleteCategory(categoryId);
        deletingCategory.put("message", " category Removed completely !");
        deletingCategory.put("Status_code", HttpStatus.CREATED.value());
        deletingCategory.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return deletingCategory;
    }


//    update Category


    }

