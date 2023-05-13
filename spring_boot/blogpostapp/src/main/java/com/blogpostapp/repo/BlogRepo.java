package com.blogpostapp.repo;

import com.blogpostapp.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Repeatable;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
}
