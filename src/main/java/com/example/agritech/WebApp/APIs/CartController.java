<<<<<<< HEAD
package com.example.agritech.WebApp.APIs;

import com.example.agritech.WebApp.DTO.AdsDao;
import com.example.agritech.WebApp.DTO.cartDao;
import com.example.agritech.WebApp.Model.Cart;
import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Repository.CartRepo;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import com.example.agritech.WebApp.Services.CartServices;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Controller
@RequestMapping("/api/v2/cart")
public class CartController {

    @Autowired
    public  CartRepo cartRepo;
    @Autowired
    public CategoryRepo categoryRepo;
    @Autowired
   public CartServices cartServices;


    // adding a new item in the cart
    @PostMapping("/ADD TO CART")
    public ResponseEntity<?> shop(@RequestBody cartDao cartDao){
        Category category = categoryRepo.getCategoriesById(cartDao.getCategoryId());
        Cart cart = new Cart();
        cart.setProductName(cartDao.getProductName());
        cart.setImage(cartDao.getImage());
        cart.setPrice(cartDao.getPrice());
        cart.setSellerName(cartDao.getSellerName());
        cart.setCategory(category);
        Map<String, Object> create = new HashMap<>();
        Cart shop = cartServices.shop(cart);
        create.put("status_code", HttpStatus.CREATED.value());
        create.put("message", " Product added to cart Successfully");
        create.put("Data", shop);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    //getting all items from the cart
    @GetMapping("/MyCart")
    public Map<String, Object> Cart (){
      Map<String, Object> view = new HashMap<>();
        List <Cart> imageView = cartRepo.findAll();
        view.put("status_code", HttpStatus.CREATED.value());
        view.put("message", "Success!" );
        view.put("Data", imageView);
        return view;
    }


    // removing from the cart
    @DeleteMapping("/remove/{cartId}")
    public Map<String, Object> removeProduct(@PathVariable Long cartId ){
        Map<String,Object> deletingProductFromCart = new HashMap<>();
        cartServices.deleteProductCartById(cartId);
        deletingProductFromCart.put("message:", "Deleted Successfully!");
        return  deletingProductFromCart;
    }
}
=======
package com.example.agritech.WebApp.APIs;

import com.example.agritech.WebApp.DTO.AdsDao;
import com.example.agritech.WebApp.DTO.cartDao;
import com.example.agritech.WebApp.Model.Cart;
import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Repository.CartRepo;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import com.example.agritech.WebApp.Services.CartServices;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Controller
@RequestMapping("/api/v2/cart")
public class CartController {

    @Autowired
    public  CartRepo cartRepo;
    @Autowired
    public CategoryRepo categoryRepo;
    @Autowired
   public CartServices cartServices;


    // adding a new item in the cart
    @PostMapping("/ADD TO CART")
    public ResponseEntity<?> shop(@RequestBody cartDao cartDao){
        Category category = categoryRepo.getCategoriesById(cartDao.getCategoryId());
        Cart cart = new Cart();
        cart.setProductName(cartDao.getProductName());
        cart.setImage(cartDao.getImage());
        cart.setPrice(cartDao.getPrice());
        cart.setSellerName(cartDao.getSellerName());
        cart.setCategory(category);
        Map<String, Object> create = new HashMap<>();
        Cart shop = cartServices.shop(cart);
        create.put("status_code", HttpStatus.CREATED.value());
        create.put("message", " Product added to cart Successfully");
        create.put("Data", shop);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    //getting all items from the cart
    @GetMapping("/MyCart")
    public Map<String, Object> Cart (){
      Map<String, Object> view = new HashMap<>();
        List <Cart> imageView = cartRepo.findAll();
        view.put("status_code", HttpStatus.CREATED.value());
        view.put("message", "Success!" );
        view.put("Data", imageView);
        return view;
    }


    // removing from the cart
    @DeleteMapping("/remove/{cartId}")
    public Map<String, Object> removeProduct(@PathVariable Long cartId ){
        Map<String,Object> deletingProductFromCart = new HashMap<>();
        cartServices.deleteProductCartById(cartId);
        deletingProductFromCart.put("message:", "Deleted Successfully!");
        return  deletingProductFromCart;
    }
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
