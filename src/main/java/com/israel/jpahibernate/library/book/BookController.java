package com.israel.jpahibernate.library.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> readAllBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        book.getAuthor().deleteBook(book);
        bookRepository.save(book);
    }

}
