<<<<<<< HEAD
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
   @Query(value = "SELECT i FROM Products i WHERE i.productName= :productName")
   List<Products> getProductByName(String productName);
@Transactional
@Modifying
@Query("DELETE  FROM Products i WHERE i.productsId= :ProductsId")
   void deleteById(@Param("ProductsId") String ProductsId);

}

=======
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
   @Query(value = "SELECT i FROM Products i WHERE i.productName= :productName")
   List<Products> getProductByName(String productName);
@Transactional
@Modifying
@Query("DELETE  FROM Products i WHERE i.productsId= :ProductsId")
   void deleteById(@Param("ProductsId") String ProductsId);

}

>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
