package com.example.agritech.WebApp.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cartDao {

    private  Long CategoryId;  //FK

    public  String image;
    public  String productName;
    public  String sellerName;
    public  String price;
}
