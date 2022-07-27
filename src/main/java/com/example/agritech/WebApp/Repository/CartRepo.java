package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

}
