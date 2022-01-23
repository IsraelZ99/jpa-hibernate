package com.israel.jpahibernate.library.book;

import com.israel.jpahibernate.library.author.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Author author;

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author getAuthor() {
        return Objects.isNull(author) ? null : new Author(author.getId(), author.getName(), author.getNationality());
    }
}
