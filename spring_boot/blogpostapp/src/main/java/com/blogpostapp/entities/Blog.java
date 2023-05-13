package com.blogpostapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "blogpost_table")
public class Blog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String content;

    public Blog(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<Comment> comments=new ArrayList<Comment>();

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setBlog(this);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
        comment.setBlog(null);
    }
}






