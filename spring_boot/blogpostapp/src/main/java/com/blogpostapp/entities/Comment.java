package com.blogpostapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "comment_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;


    private LocalDateTime createdAt;
    @JoinColumn(name = "bid_fk")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional =false)
    private Blog blog;

    public Comment(Blog blog, String comment) {
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.blog = blog;
    }
}
