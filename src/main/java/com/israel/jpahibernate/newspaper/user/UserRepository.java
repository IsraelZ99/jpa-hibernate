package com.israel.jpahibernate.newspaper.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT usr " +
            "FROM User usr " +
            "JOIN usr.publishing publishing " +
            "JOIN publishing.comments comments")
    Iterable<User> findAllUsersWithPublishingAndComments();

    @Query(value = "SELECT usr " +
            "FROM User usr " +
            "JOIN usr.publishing publishing " +
            "JOIN publishing.comments comments " +
            "WHERE usr.id = :userId")
    Iterable<User> findUserByIdWithPublishingAndComments(@Param("userId") Long userId);

}
