<<<<<<< HEAD
package com.example.agritech.WebApp.Services;
import com.example.agritech.WebApp.Model.Products;
import com.example.agritech.WebApp.Repository.ProductsRepo;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public  ProductsRepo productsRepo;
    public Products createProduct(Products products) {
        return productsRepo.save(products);
    }

    public List<Products> removeProduct(String productsId) {
        productsRepo.deleteById(Long.valueOf(productsId));
        return null;
    }
    public Products updateProduct(Products products){
        Products existingProducts =
                productsRepo.findById(products.getProductsId())
                        .orElse(null);
        existingProducts.setPrice(products.getPrice());
        existingProducts.setDescription(products.getDescription());
        existingProducts.setProductName(products.getProductName());
        existingProducts.setImage(products.getImage());
        existingProducts.setLocation(products.getLocation());
//        existingProducts.setCategory(products.getCategory());
        return productsRepo.save(existingProducts);
    }
    public Products saveProducts(Products updatedProduct) {
        return  productsRepo.save(updatedProduct);
    }

    public List<Products> getProductByName(String name) {
       return productsRepo.getProductByName(name);
    }
}














=======
package com.example.agritech.WebApp.Services;
import com.example.agritech.WebApp.Model.Products;
import com.example.agritech.WebApp.Repository.ProductsRepo;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public  ProductsRepo productsRepo;
    public Products createProduct(Products products) {
        return productsRepo.save(products);
    }

    public List<Products> removeProduct(String productsId) {
        productsRepo.deleteById(Long.valueOf(productsId));
        return null;
    }
    public Products updateProduct(Products products){
        Products existingProducts =
                productsRepo.findById(products.getProductsId())
                        .orElse(null);
        existingProducts.setPrice(products.getPrice());
        existingProducts.setDescription(products.getDescription());
        existingProducts.setProductName(products.getProductName());
        existingProducts.setImage(products.getImage());
        existingProducts.setLocation(products.getLocation());
//        existingProducts.setCategory(products.getCategory());
        return productsRepo.save(existingProducts);
    }
    public Products saveProducts(Products updatedProduct) {
        return  productsRepo.save(updatedProduct);
    }

    public List<Products> getProductByName(String name) {
       return productsRepo.getProductByName(name);
    }
}














>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
