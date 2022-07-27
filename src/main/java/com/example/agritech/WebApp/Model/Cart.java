package com.example.agritech.WebApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Cart")
public class Cart {
    @Id
      @SequenceGenerator(
              name = "sequence-name"
      )
      @GeneratedValue (
              strategy = GenerationType.IDENTITY
      )
    public  Long cartId;
    public  String image;
    public  String productName;
    public  String sellerName;
    public  String price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_CATEGORY_CART"))

     private Category category;
}
