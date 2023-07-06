package com.example.blogplatform.blog.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blogposts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "blog_title")
    private String title;

    @Column(name = "blog_content")
    private String content;

    @Column(name = "blog_author")
    private String author;
}
