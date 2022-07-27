package com.example.agritech.WebApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsDao {

    private  Long CategoryId;  //FK
    public String location;
    public String photo;
    public String description;
    public Integer quantity;
    public String price;
    public String title;
}
