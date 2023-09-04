package com.jpa.crud.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publication_date")
    private String publicationDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "author")
    private String author;
    @Column(name = "description",length = 1000)
    private String description;
    public Book() {
    }

    public Book(Long id, String title, String publicationDate, String imageUrl, String author, String description) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.imageUrl = imageUrl;
        this.author = author;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
