package com.blogpostapp.service;

import com.blogpostapp.entities.Blog;

import java.util.List;

public interface BlogService {
    public List<Blog> getAll();
    public Blog postBlog(Blog blog);
    public Blog updateBlog(Long blogId, Blog blog);
    public Blog deleteBlog(Long blogId);
    public Blog getById(Long blogId);
}
