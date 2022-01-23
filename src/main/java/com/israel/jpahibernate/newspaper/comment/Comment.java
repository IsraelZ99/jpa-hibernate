package com.israel.jpahibernate.newspaper.comment;

import com.israel.jpahibernate.newspaper.publishing.Publishing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @Column
    private Long id;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn
    private Publishing publishing;

    public Comment(Long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

}
