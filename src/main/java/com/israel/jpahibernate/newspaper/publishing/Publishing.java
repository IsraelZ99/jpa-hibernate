package com.israel.jpahibernate.newspaper.publishing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.israel.jpahibernate.newspaper.comment.Comment;
import com.israel.jpahibernate.newspaper.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publishing")
@Data
@NoArgsConstructor
public class Publishing {

    @Id
    @Column
    public Long id;

    @Column
    private String tittle;

    @ManyToOne
    @JoinColumn
    private User author;

    @OneToMany(mappedBy = "publishing", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Publishing(Long id, String tittle, User author) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
    }

    public Publishing(Long id, String tittle, List<Comment> comments) {
        this.id = id;
        this.tittle = tittle;
        this.comments = comments;
    }

    public Publishing(Long id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        if (!comments.isEmpty()) {
            List<Comment> singleComments = new ArrayList<>();
            comments.forEach(comment -> singleComments.add(new Comment(comment.getId(), comment.getComment())));
            return singleComments;
        }
        return new ArrayList<>();
    }

    public User getAuthor() {
        return Objects.isNull(author) ? null : new User(author.getId(), author.getName());
    }
}
