package com.example.agritech.WebApp.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategoryDao {
    public Long categoryId;

    public @NotNull String categoryName;

    public @NotNull String total;

    public @NotNull String icon;

}
