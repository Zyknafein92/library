package com.library.borrowmicroservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Book {

    private String id;
    private String title;
    private String author;
    private String description;
    private String gender;
    private String picture;
    private Boolean avaible;

    public Book() {
    }
}