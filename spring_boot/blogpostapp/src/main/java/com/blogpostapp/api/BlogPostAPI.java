package com.blogpostapp.api;

import com.blogpostapp.entities.Blog;
import com.blogpostapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class BlogPostAPI {

    //ResponeEntity = data + status code

    private BlogService blogService;

    @Autowired
    public BlogPostAPI(BlogService blogService) {
        this.blogService = blogService;
    }
    //--------show all blogs---------------

    @GetMapping(path = "blogs")
    public ResponseEntity<List<Blog>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getAll());
    }

    //--------Get by Id------------U need to write exception handler ---
    @GetMapping(path = "blogs/{blogId}")
    public ResponseEntity<Blog>  getById( @PathVariable Long blogId){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getById(blogId));
    }

    //--------Addd new blog---------------
    @PostMapping  (path = "blogs")
    public ResponseEntity<Blog> addBlogs(@RequestBody  Blog blog){
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.postBlog(blog));
    }

    //-------update---------------
    @PutMapping (path = "blogs/{blogId}")
    public ResponseEntity<Blog> updateBlogs( @PathVariable Long blogId, @RequestBody  Blog blog){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.updateBlog(blogId, blog));
    }

    //-------delete---------------
    @DeleteMapping(path = "blogs/{blogId}")
    public ResponseEntity<Void> deteteById( @PathVariable Long blogId){
         blogService.deleteBlog(blogId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //
}
