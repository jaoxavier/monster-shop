package io.github.jaoxavier.monstershop.domain.entity;

import io.github.jaoxavier.monstershop.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private String category;
    private Integer stock;
    private String urlImage;

    public Monster(String name, Double price, Category category, Integer stock, String urlImage) {
        this.name = name;
        this.price = price;
        this.category = category.toString();
        this.stock = stock;
        this.urlImage = urlImage;
    }
}
