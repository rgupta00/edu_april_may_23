package com.blogpostapp.service.impl;

import com.blogpostapp.exceptions.ResouceNotFoundException;
import com.blogpostapp.entities.Blog;
import com.blogpostapp.repo.BlogRepo;
import com.blogpostapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private BlogRepo blogRepo;

    @Autowired
    public BlogServiceImpl(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }
    @Override
    public List<Blog> getAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog postBlog(Blog blog) {
         blogRepo.save(blog);
         return  blog;
    }

    @Override
    public Blog updateBlog(Long blogId, Blog blog) {
        Blog blogToUpdate= getById(blogId);
        blogToUpdate.setContent(blog.getContent());
        blogToUpdate.setContent(blog.getContent());
        blogRepo.save(blogToUpdate);

        return blogToUpdate;
    }

    @Override
    public Blog deleteBlog(Long blogId) {
        Blog blogToDelete= getById(blogId);
        blogRepo.delete(blogToDelete);
        return blogToDelete;
    }

    @Override
    public Blog getById(Long blogId) {
        return blogRepo.findById(blogId)
                .orElseThrow(()-> new ResouceNotFoundException("blogpost with id "+ blogId +" is not found"));
    }
}









