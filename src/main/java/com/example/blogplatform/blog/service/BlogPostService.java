package com.example.blogplatform.blog.service;

import com.example.blogplatform.blog.exception.BlogPostNotFoundException;
import com.example.blogplatform.blog.model.BlogPost;
import com.example.blogplatform.blog.repository.BlogPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    private BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
    public BlogPost saveBlog(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostByID(long id) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        } else {
            throw new BlogPostNotFoundException(id);
        }
    }
    
    public BlogPost updateBlogPost(BlogPost blogPost, long id) {
        //check if given id exists or not
        BlogPost existingBlogPost = blogPostRepository.findById(id).orElseThrow(() -> new BlogPostNotFoundException(id));

        existingBlogPost.setTitle(blogPost.getTitle());
        existingBlogPost.setContent(blogPost.getContent());
        existingBlogPost.setAuthor(blogPost.getAuthor());

        blogPostRepository.save(existingBlogPost);
        return existingBlogPost;
    }

    public void deleteBlogPost(long id) {
        //check to see given id exists first
        blogPostRepository.findById(id).orElseThrow(() ->
                new BlogPostNotFoundException(id));
        blogPostRepository.deleteById(id);
    }
}
