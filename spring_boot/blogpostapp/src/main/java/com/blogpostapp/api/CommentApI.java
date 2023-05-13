package com.blogpostapp.api;

import com.blogpostapp.entities.Comment;
import com.blogpostapp.repo.CommentRepo;
import com.blogpostapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CommentApI {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepo commentRepo;


    //--------gettting all the comments-------
    @GetMapping(path = "comments")
    public ResponseEntity<List<Comment>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAll());
    }

    //--------gettting all the comments releated to a blog post-------
    @GetMapping(path = "blogs/{blogId}/comments")
    public List<Comment> getAllCommentByBlogPost( @PathVariable(name = "blogId") Long blogId){
        return  commentRepo.findByBlogId(blogId);
//        List<Comment> comments=commentService.getAllCommentsByBlogID(blogId);
//        System.out.println("--------------------------------");
//        comments.forEach(c-> System.out.println(c.getComment()));
//        System.out.println("--------------------------------");
//        return ResponseEntity.status(HttpStatus.OK).
//                body(commentService.getAllCommentsByBlogID(blogId));
    }

    //--------Add comment to an existing to a blog post-------
    @PostMapping(path = "blogs/{blogId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable(name = "blogId") Long blogId,
                                               @RequestBody  Comment comment){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(commentService.createComment(blogId,comment ));
    }

    //---------update the comment -> blog id , comment id , comment that need to update
    @PutMapping (path = "blogs/{blogId}/comments/{commentId}")
    public ResponseEntity<Comment> udpateComment(@PathVariable(name = "blogId") Long blogId,
                                                 @PathVariable(name = "commentId") Long commentId,
                                                 @RequestBody  Comment comment){
        return ResponseEntity.status(HttpStatus.OK).
                body(commentService.updateComment(blogId, commentId, comment));
    }

    @DeleteMapping  (path = "blogs/{blogId}/comments/{commentId}")
    public ResponseEntity<Comment> deleteComment(@PathVariable(name = "blogId") Long blogId,
                                                 @PathVariable(name = "commentId") Long commentId){
        return ResponseEntity.status(HttpStatus.OK).
                body(commentService.deleteComment(blogId, commentId));
    }
}










