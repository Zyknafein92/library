package com.library.bookmicroservice.services;

import com.library.bookmicroservice.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(Long id);

    Book createBook(BookDTO bookDTO) throws BookCreationException;

    void updateBook(BookDTO bookDTO);

    void deleteBook(long id);


}
