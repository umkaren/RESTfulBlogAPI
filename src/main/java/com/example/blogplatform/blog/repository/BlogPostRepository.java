package com.example.blogplatform.blog.repository;

import com.example.blogplatform.blog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
