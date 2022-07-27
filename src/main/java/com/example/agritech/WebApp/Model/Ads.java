<<<<<<< HEAD
package com.example.agritech.WebApp.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ads")
public class Ads {
    @Id
    @SequenceGenerator(
            name = "sequence-name"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public  Long adsId;
    @NotNull
    @NotBlank(message = "Location Cannot be empty")
    public String location;
    @NotNull
    @NotBlank(message = "Please upload an image not exceeding 5 Mb. " +
            "Supported formats are *.jpg, *gif and *.png" +
            "Maximum of 20 images is allowed")
    public String photo;
    @NotNull
    @NotBlank(message = "title Cannot be empty")
    public String title;
    @NotNull
    @NotBlank(message = "description Cannot be empty")
    public String description;
    public Integer quantity;
    @NotNull
    @NotBlank(message = "price Cannot be empty")
    public String price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="categoryId",
              nullable = false,
    foreignKey = @ForeignKey(name = "FK_CATEGORY"))
    private Category category;
=======
package com.example.agritech.WebApp.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ads")
public class Ads {
    @Id
    @SequenceGenerator(
            name = "sequence-name"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public  Long adsId;
    @NotNull
    @NotBlank(message = "Location Cannot be empty")
    public String location;
    @NotNull
    @NotBlank(message = "Please upload an image not exceeding 5 Mb. " +
            "Supported formats are *.jpg, *gif and *.png" +
            "Maximum of 20 images is allowed")
    public String photo;
    @NotNull
    @NotBlank(message = "title Cannot be empty")
    public String title;
    @NotNull
    @NotBlank(message = "description Cannot be empty")
    public String description;
    public Integer quantity;
    @NotNull
    @NotBlank(message = "price Cannot be empty")
    public String price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="categoryId",
              nullable = false,
    foreignKey = @ForeignKey(name = "FK_CATEGORY"))
    private Category category;
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
}