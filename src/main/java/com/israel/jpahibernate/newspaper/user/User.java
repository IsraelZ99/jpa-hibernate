package com.israel.jpahibernate.newspaper.user;

import com.israel.jpahibernate.newspaper.comment.Comment;
import com.israel.jpahibernate.newspaper.publishing.Publishing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Publishing> publishing = new ArrayList<>();

    @PreRemove
    public void setNullPublishing(){
        publishing.forEach(publish -> publish.setAuthor(null));
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Publishing> getPublishing() {
        List<Publishing> singlePublishing = new ArrayList<>();
        publishing.forEach(publish -> {
            List<Comment> singleComments = new ArrayList<>();
            publish.getComments().forEach(comment -> singleComments.add(new Comment(comment.getId(), comment.getComment())));
            singlePublishing.add(new Publishing(publish.id, publish.getTittle(), singleComments));
        });
        return singlePublishing;
    }
}
