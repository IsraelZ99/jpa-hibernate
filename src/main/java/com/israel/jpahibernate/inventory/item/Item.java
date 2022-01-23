package com.israel.jpahibernate.inventory.item;

import com.israel.jpahibernate.inventory.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {

    @Id
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "item_id_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Double price;

    private Long quantity;

    @ManyToMany
    @JoinTable
    private List<Category> categories = new ArrayList<>();

    public Item(String name, Double price, Long quantity, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
    }

    public List<Category> getCategories() {
        List<Category> singleCategories = new ArrayList<>();
        categories.forEach(category -> singleCategories.add(new Category(category.getId(), category.getCategory())));
        return singleCategories;
    }
}
