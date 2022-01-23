package com.israel.jpahibernate.inventory.category;

import com.israel.jpahibernate.inventory.item.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "category_id_seq" ,strategy = GenerationType.SEQUENCE)
    private Long id;

    private String category;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    public Category(String category) {
        this.category = category;
    }

    public Category(Long id, String category) {
        this.id = id;
        this.category = category;
    }
}
