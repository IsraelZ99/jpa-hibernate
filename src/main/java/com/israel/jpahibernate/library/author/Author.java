package com.israel.jpahibernate.library.author;

import com.israel.jpahibernate.library.book.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
public class Author {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Author(Long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public List<Book> getBooks() {
        List<Book> booksWithoutAuthor = new ArrayList<>();
        books.forEach(book -> booksWithoutAuthor.add(new Book(book.getId(), book.getName())));
        return booksWithoutAuthor;
    }

    // Desasociar un libro de un autor para que quede sin autor.
    public void deleteBook(Book book){
        books.remove(book);
        book.setAuthor(null);
    }


}
