package com.blogpostapp.service.impl;

import com.blogpostapp.entities.Blog;
import com.blogpostapp.entities.Comment;
import com.blogpostapp.exceptions.ResouceNotFoundException;
import com.blogpostapp.repo.BlogRepo;
import com.blogpostapp.repo.CommentRepo;
import com.blogpostapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private CommentRepo commentRepo;
    private BlogRepo blogRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo, BlogRepo blogRepo) {
        this.commentRepo = commentRepo;
        this.blogRepo = blogRepo;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public List<Comment> getAllCommentsByBlogID(Long blogId) {
        return  commentRepo.findByBlogId(blogId);
    }

    @Override
    public Comment createComment(Long blogId, Comment comment) {
        //1. first find the comment
        Blog blog=blogRepo.findById(blogId)
                .orElseThrow(() -> new ResouceNotFoundException("blog with id "+ blogId +" is not found"));

        //2. add comment to the blog
        blog.addComment(comment);

        //3. save the blog
        blogRepo.save(blog);

        //4. save the comment  ?
        //commentRepo.save(comment);

        return comment;
    }

    @Override
    public Comment updateComment(Long blogId, Long commentId, Comment comment) {
        //1. find the blog if it is there or else throw ex
        Blog blog=blogRepo.findById(blogId)
                .orElseThrow(() -> new ResouceNotFoundException("blog with id "+ blogId +" is not found"));

        //1. find the comment if it is there or else throw ex
        Comment commentToUpdate= commentRepo.findById(commentId)
                .orElseThrow(() -> new ResouceNotFoundException("comment with id "+ commentId + "is not found"));

        commentToUpdate.setComment(comment.getComment());

        commentRepo.save(commentToUpdate);

        return commentToUpdate;
    }

    @Override
    public Comment deleteComment(Long blogId, Long commentId) {
        //1.find the blog with a id and comment with id             12  --- 112 if not found throw the ex
        Comment comment=commentRepo.findByIdAndBlogId(commentId, blogId)
                .orElseThrow(() -> new ResouceNotFoundException("comment related to that blog is not found"));

        commentRepo.delete(comment);

        return comment;
    }
}















