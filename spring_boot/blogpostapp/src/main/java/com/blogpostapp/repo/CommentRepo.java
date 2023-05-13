package com.blogpostapp.repo;

import com.blogpostapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    //find all the comments related to a specific blog id
    List<Comment> findByBlogId(Long blogId);

    //find a specific comment of a specfic blog
    Optional<Comment> findByIdAndBlogId(Long id, Long postId);
}
