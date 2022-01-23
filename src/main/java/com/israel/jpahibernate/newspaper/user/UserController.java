package com.israel.jpahibernate.newspaper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}/publishing/comments")
    public Iterable<User> readUserByIdWithPublishingAndComments(@PathVariable Long id){
        return userRepository.findUserByIdWithPublishingAndComments(id);
    }

    @GetMapping("/publishing/comments")
    public Iterable<User> readAllUsersWithPublishingAndComments(){
        return userRepository.findAllUsersWithPublishingAndComments();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
