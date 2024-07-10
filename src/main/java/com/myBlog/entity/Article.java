package com.myBlog.entity;

import jakarta.persistence.Entity;

@Entity
public class Article {

    private Long id;

    private String title;

    private String content;

}
