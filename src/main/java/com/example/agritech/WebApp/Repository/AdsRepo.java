package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Model.Ads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepo extends JpaRepository<Ads, Long> {
}
