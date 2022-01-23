package com.israel.jpahibernate;

import com.israel.jpahibernate.inventory.category.Category;
import com.israel.jpahibernate.inventory.category.CategoryRepository;
import com.israel.jpahibernate.inventory.item.Item;
import com.israel.jpahibernate.inventory.item.ItemRepository;
import com.israel.jpahibernate.job.address.Address;
import com.israel.jpahibernate.library.author.Author;
import com.israel.jpahibernate.library.author.AuthorRepository;
import com.israel.jpahibernate.library.book.Book;
import com.israel.jpahibernate.library.book.BookRepository;
import com.israel.jpahibernate.job.employee.Employee;
import com.israel.jpahibernate.job.employee.EmployeeRepository;
import com.israel.jpahibernate.newspaper.comment.Comment;
import com.israel.jpahibernate.newspaper.comment.CommentRepository;
import com.israel.jpahibernate.newspaper.publishing.Publishing;
import com.israel.jpahibernate.newspaper.publishing.PublishingRepository;
import com.israel.jpahibernate.newspaper.user.User;
import com.israel.jpahibernate.newspaper.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class AddData {

    private final EmployeeRepository employeeRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final PublishingRepository publishingRepository;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Bean
    public void createEmployees() {
        employeeRepository.save(new Employee(1L, "Israel", "Garcia",
                LocalDate.of(1999, 10, 23),
                new Address(1L, "Campanario", 54933L, "Mexico")));
    }

    @Bean
    public void createAuthors() {
        Author author1 = authorRepository.save(new Author(1L, "Pablo Perez", "Mexicana"));
        Author author2 = authorRepository.save(new Author(2L, "Elena Gomez", "Chilena"));
        Author author3 = authorRepository.save(new Author(3L, "Miguel Lopez", "Africana"));

        bookRepository.save(new Book(1L, "Programar Java es facil", author3));
        bookRepository.save(new Book(2L, "Vestir a la moda", author3));
        bookRepository.save(new Book(3L, "Cocinar facil", author1));
        bookRepository.save(new Book(4L, "Programar no es tan facil", author2));
        bookRepository.save(new Book(5L, "Lovota", author2));
    }

    @Bean
    public void createPublishing() {
        User user1 = new User(1L, "Israel");
        User user2 = new User(2L, "Jose");
        userRepository.save(user1);
        userRepository.save(user2);

        Publishing publishing1 = new Publishing(1L, "Hoy hara frio?", user1);
        Publishing publishing2 = new Publishing(2L, "Te gustan los videojuegos?", user2);
        publishingRepository.save(publishing1);
        publishingRepository.save(publishing2);

        Comment comment1 = new Comment(1L, "Aqui no hay nada de frio", publishing1);
        Comment comment2 = new Comment(2L, "Amo los videojuegos", publishing2);
        commentRepository.save(comment1);
        commentRepository.save(comment2);

    }

    @Bean
    public void createInventory() {
        Category category1 = new Category("Papeleria");
        Category category2 = new Category("Cuidado personal");
        Category category3 = new Category("Higiene personal");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        Item item1 = new Item("lapiz", 15.50, 10L, Arrays.asList(category1));
        Item item2 = new Item("borrador", 5.50, 15L, Arrays.asList(category1));
        Item item3 = new Item("jabon", 45.50, 40L, Arrays.asList(category2, category3));
        Item item4 = new Item("shampoo", 62.50, 50L, Arrays.asList(category2, category3));
        itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));


    }

}
