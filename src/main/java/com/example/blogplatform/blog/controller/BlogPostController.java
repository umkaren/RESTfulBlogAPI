package com.example.blogplatform.blog.controller;

import com.example.blogplatform.blog.model.BlogPost;
import com.example.blogplatform.blog.service.BlogPostService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/blogPosts")
public class BlogPostController {

    private BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    // create blog post API
    @PostMapping
    public ResponseEntity<EntityModel<BlogPost>> saveBlog(@RequestBody BlogPost blogPost) {
        BlogPost savedBlogPost = blogPostService.saveBlog(blogPost);
        return new ResponseEntity<>(addSelfLink(savedBlogPost), HttpStatus.CREATED);
    }

    // retrieve all blog posts API
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<BlogPost>>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        List<EntityModel<BlogPost>> blogPostModels = blogPosts.stream()
                .map(this::addSelfLink)
                .collect(Collectors.toList());
        Link link = Link.of("/api/blogPosts").withSelfRel();
        CollectionModel<EntityModel<BlogPost>> collectionModel = CollectionModel.of(blogPostModels, link);
        return ResponseEntity.ok(collectionModel);
    }

    // retrieve blog post by id API
    @GetMapping("{id}")
    public ResponseEntity<EntityModel<BlogPost>> getPostByID(@PathVariable("id") long postId) {
        BlogPost blogPost = blogPostService.getBlogPostByID(postId);
        return ResponseEntity.ok(addSelfLink(blogPost));
    }

    // update blog post info API
    @PutMapping("{id}")
    public ResponseEntity<EntityModel<BlogPost>> updateBlogPost(@PathVariable("id") long id, @RequestBody BlogPost blogPost) {
        BlogPost updatedBlogPost = blogPostService.updateBlogPost(blogPost, id);
        return ResponseEntity.ok(addSelfLink(updatedBlogPost));
    }

    // delete blog post API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable("id") long id) {
        blogPostService.deleteBlogPost(id);
        return new ResponseEntity<>("Blog post deleted successfully.", HttpStatus.OK);
    }

    private EntityModel<BlogPost> addSelfLink(BlogPost blogPost) {
        long postId = blogPost.getId();
        Link selfLink = Link.of("/api/blogPosts/" + postId).withSelfRel();
        return EntityModel.of(blogPost, selfLink);
    }
}
