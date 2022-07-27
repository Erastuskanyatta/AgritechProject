package com.example.agritech.WebApp.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDao {

    private  Long CategoryId;
    public String image;
    public @NotNull String productName;
    public @NotNull int price;
    public  @NotNull String description;
    public String location;


}
