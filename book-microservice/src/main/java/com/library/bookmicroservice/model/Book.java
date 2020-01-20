package com.library.bookmicroservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Size(max = 5000)
    @Column(name = "description")
    private String description;


    @Column(name= "editor")
    private String editor;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date parution;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "picture")
    private String picture;

    @NotNull
    @Column(name = "avaible")
    private Boolean avaible;

    @NotNull
    @Column(name = "library_ID")
    private String LibraryID;

    public Book() {
    }

}