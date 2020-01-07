package com.library.bookmicroservice.services;

import com.library.bookmicroservice.exceptions.BookCreationException;
import com.library.bookmicroservice.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    List<Book> searchBooks(String criteria);

    Book getBook(Long id);

    Book createBook(BookDTO bookDTO) throws BookCreationException;

    void updateBook(BookDTO bookDTO);

    void deleteBook(Long id);


}
