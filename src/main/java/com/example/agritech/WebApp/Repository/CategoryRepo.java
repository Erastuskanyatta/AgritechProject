package com.example.agritech.WebApp.Repository;


import com.example.agritech.WebApp.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("select  i from Category i WHERE i.categoryId = :categoryId")
    Category getCategoriesById(@Param("categoryId") Long categoryName);

    @Query("SELECT i FROM Category i WHERE i.categoryName = :categoryName")
    List<Category> getCategoriesByCategoryName(@Param("categoryName") String categoryName);
    @Query("SELECT i.total FROM Category i WHERE i.categoryName = :categoryName")
    List<Category> findAllCategories(@Param("categoryName") String categoryName);

//    @Query(value = "SELECT i.categoryName, i.total, i.icon FROM Category i", nativeQuery = true)
//    Optional<Category> findAllByCategoryId(@Param("categoryId") Long categoryId);

//    @Query("SELECT i.categoryName, i.icon,i.total FROM Category i WHERE i.categoryName = :categoryName")
//    List <Category> getAllCategories(@Param("categoryName") String categoryName);

//    @Transactional
//    @Modifying
//    @Query("DELETE  FROM Category i WHERE i.categoryName= :Id")
//    void deleteById(@Param("Id") String Id);

}
