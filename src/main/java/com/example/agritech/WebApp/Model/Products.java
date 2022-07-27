package com.example.agritech.WebApp.Model;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Products{
    @Id
    @SequenceGenerator(
            name = "sequence-name"

    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public Long productsId;
    public String image;
    public @NotNull String productName;
    public @NotNull int price;
    public  String timePosted;
    public  @NotNull String description;
    public String location;
    public String totalView;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_CATEGORY"))

    private Category category ;
}
