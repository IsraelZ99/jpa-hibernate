package com.israel.jpahibernate.newspaper.publishing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingRepository extends JpaRepository<Publishing, Long> {

    @Query(value = "SELECT publishing.comments FROM Publishing publishing WHERE publishing.author.id = :userId")
    Iterable<Publishing> findAllPublishingWithCommentsByUserId(@Param("userId") Long userId);

}
