package com.israel.jpahibernate.library.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping
    public Iterable<Author> readAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author readAuthorById(@PathVariable Long id){
        return authorRepository.findById(id)
                .orElseThrow();
    }

}
