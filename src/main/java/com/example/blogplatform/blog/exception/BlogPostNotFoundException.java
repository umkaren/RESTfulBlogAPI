package com.example.blogplatform.blog.exception;

public class BlogPostNotFoundException extends RuntimeException{
    public BlogPostNotFoundException(Long id) {
        super("Could not find blog post " + id);
    }
}
