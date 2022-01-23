package com.israel.jpahibernate.newspaper.publishing;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publishing")
@RequiredArgsConstructor
public class PublishingController {

    private final PublishingRepository publishingRepository;

    @GetMapping("/author/comment")
    public Iterable<Publishing> readAllPublishingWithAuthorAndComments(){
        return publishingRepository.findAll();
    }

    @GetMapping("/author/{id}/comment")
    public Iterable<Publishing> readAllPublishingWithCommentsByIdAuthor(@PathVariable Long id){
        return publishingRepository.findAllPublishingWithCommentsByUserId(id);
    }

}
