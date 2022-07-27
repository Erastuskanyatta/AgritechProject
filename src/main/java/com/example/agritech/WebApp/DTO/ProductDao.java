<<<<<<< HEAD
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
=======
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
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
