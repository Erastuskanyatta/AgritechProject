package com.example.agritech.WebApp.APIs;
import com.example.agritech.WebApp.DTO.ProductDao;
import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Model.Products;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import com.example.agritech.WebApp.Repository.ProductsRepo;
import com.example.agritech.WebApp.Services.ProductService;
import com.sun.tools.jconsole.JConsoleContext;
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
@CrossOrigin(origins = "http://localhost:4040")
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    public final ProductsRepo productsRepo;
    @Autowired
    public final CategoryRepo categoryRepo;
    @Autowired
    public final ProductService productService;

    public ProductController(ProductsRepo productsRepo, CategoryRepo categoryRepo, ProductService productService) {
        this.productsRepo = productsRepo;
        this.categoryRepo = categoryRepo;
        this.productService = productService;
    }

    // creating a new product
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDao productDto) {

        Category category = categoryRepo.getCategoriesById(productDto.getCategoryId());
        Products products = new Products();
        products.setImage(productDto.getImage());
        products.setProductName(productDto.getProductName());
        products.setPrice(productDto.getPrice());
        products.setDescription(productDto.getDescription());
        products.setLocation(productDto.getLocation());
        products.setCategory(category);
        Map<String, Object> creatingAProduct = new HashMap<>();

        Products createProduct = productService.createProduct(products);
        creatingAProduct.put("status_code", HttpStatus.CREATED.value());
        creatingAProduct.put("message", " Product Created Successfully 🎉 🎆 🧨 🎇 🎍");
        creatingAProduct.put("data", createProduct);
        return new ResponseEntity<>(creatingAProduct, HttpStatus.CREATED);
    }

    // Viewing All  products
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/AllProducts")
    public Map<String, Object> Products() {
        Map<String, Object> viewProducts = new HashMap<>();
        List<Products> ListView = productsRepo
                .findAll()
                .stream()
                .collect(Collectors.toList());
        viewProducts.put("status-code", HttpStatus.CREATED.value());
        viewProducts.put("Message", "Products retrieved successfully!");
        viewProducts.put("data", ListView);
        viewProducts.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return viewProducts;
    }

    // view product by name
    @ResponseBody
    @GetMapping("/products/{name}")
    public Map<String, Object> ViewProduct(@PathVariable String name) {
        Map<String, Object> listingOneProduct = new HashMap<>();
        List<Products> singleProduct = productService.getProductByName(name);
        listingOneProduct.put("Message", "Success!!");
        listingOneProduct.put("Status_code", HttpStatus.CREATED.value());
        listingOneProduct.put("Data", singleProduct);
        listingOneProduct.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return listingOneProduct;
    }

    //delete product by productID
    @ResponseBody
    @DeleteMapping("{productsId}")
    public Map<String, Object> removeItem(@PathVariable("productsId") String productsId) {
        Map<String, Object> DeletingProduct = new HashMap<>();
        productService.removeProduct(productsId);
        DeletingProduct.put("message", "Product removed successfully!");
        DeletingProduct.put("Status_code", HttpStatus.CREATED.value());
        DeletingProduct.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return DeletingProduct;
    }
    //update product by ProductId
    @PutMapping("/update/{productsId}")
    public ResponseEntity<?> updatedProducts( @RequestBody Products products){
        Map<String, Object> update = new HashMap<>();
        Products updateProducts =  productService.updateProduct(products);
        update.put("message", "Product Updated successfully!");
        update.put("Status_code", HttpStatus.CREATED.value());
        update.put("new data", updateProducts);
        update.put("connection", JConsoleContext.ConnectionState.CONNECTED);
        return new ResponseEntity<>(update, HttpStatus.CREATED);
    }

}










