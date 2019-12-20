package com.library.bookmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "book", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;


    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "gender")
    private String gender;

    @Column(name = "picture")
    private String picture;

    @Column(name = "avaible")
    private Boolean avaible;

    @Column(name = "library_ID")
    private String LibraryID;

    public Book() {
    }

    public Book(String title, String author, String description, String gender, String picture, Boolean avaible, String libraryID) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.gender = gender;
        this.picture = picture;
        this.avaible = avaible;
        this.LibraryID = libraryID;
    }

}