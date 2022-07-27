package com.example.agritech.WebApp.Model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Category")
public class Category {

  @Id
  @SequenceGenerator(
          name = "sequence-name"
  )
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  public Long categoryId;
  @Column(name = "categoryName")
  public @NotNull String categoryName;
  @Column(name = "total")
  public @NotNull String total;
  @Column(name = "icon")
  public @NotNull String icon;

  public String getCategoryName() {
    return categoryName;
  }
}




