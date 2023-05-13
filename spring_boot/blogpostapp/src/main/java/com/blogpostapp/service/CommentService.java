package com.blogpostapp.service;

import com.blogpostapp.entities.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getAll();

    public List<Comment> getAllCommentsByBlogID(Long blogId);

    public Comment createComment(Long blogId, Comment comment);

    public Comment updateComment(Long blogId, Long commentId, Comment comment);

    public Comment deleteComment(Long blogId, Long commentId);
}
