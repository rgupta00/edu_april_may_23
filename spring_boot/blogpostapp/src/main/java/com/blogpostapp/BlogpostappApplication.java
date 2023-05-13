package com.blogpostapp;

import com.blogpostapp.entities.Blog;
import com.blogpostapp.entities.Comment;
import com.blogpostapp.repo.BlogRepo;
import com.blogpostapp.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BlogpostappApplication implements CommandLineRunner {

	@Autowired
	private BlogRepo blogRepo;

	@Autowired
	private CommentRepo commentRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogpostappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Comment> comments=commentRepo.findByBlogId(2L);
		comments.forEach(c-> System.out.println(c.getComment()));

		//-------just we have 2 blogs
//		Blog blog=new Blog("spring5", "amit", "spring 5 is lastest form spring.io");
//		Blog blog2=new Blog("java8", "raj", "java 8 is morden java");

		//all comment to blog 1
//		Comment comment1=new Comment(blog, "good blog on spring 5");
//		Comment comment2=new Comment(blog, "spring 5 rock");
//		Comment comment3=new Comment(blog, "i need basic into to spring first");
//
//
//		//all comment to blog 2
//		Comment comment4=new Comment(blog2, "good blog on spring 8");
//		Comment comment5=new Comment(blog2, "need more details");
//		Comment comment6=new Comment(blog2, "i need basic of collection");

//		blogRepo.save(blog);
//
//		commentRepo.save(comment1);
//		commentRepo.save(comment2);
//		commentRepo.save(comment3);
//
//		blogRepo.save(blog2);
//
//		commentRepo.save(comment4);
//		commentRepo.save(comment5);
//		commentRepo.save(comment6);

		System.out.println("----------------added----------------");
	}
}














