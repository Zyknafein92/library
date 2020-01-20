package com.library.bookmicroservice.services;

import com.library.bookmicroservice.exceptions.BookCreationException;
import com.library.bookmicroservice.exceptions.BookNotFoundException;
import com.library.bookmicroservice.model.Book;
import com.library.bookmicroservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String criteria) {
        List<Book> searchResult = bookRepository.searchBook(criteria);
        if(searchResult == null) throw new BookNotFoundException("Aucun livre ne correspond à la recherche");
        return searchResult;
    }

    @Override
    public Book getBook(Long id) {
        Book book = bookRepository.getOne(id);
        if (book == null) throw new BookNotFoundException("Le livre recherché n'a pas été trouvé");
        return book;
    }

    @Override
    public Book createBook(BookDTO bookDTO) {
     //todo null pour editeur
        if (bookDTO.getLibraryID() == null) {
            throw new BookCreationException("Veuillez renseigner l'ID de la librairie");
        }

        if (bookDTO.getAvaible() == null) {
            throw new BookCreationException("Veuillez renseigner la disponibilité du livre");
        }

        if (bookDTO.getAuthor() == null) {
            throw new BookCreationException("Veuillez ajouter un nom d'auteur");
        }

        if (bookDTO.getDescription() == null) {
            throw new BookCreationException("Veuillez ajouter une description à l'ouvrage");
        }

        if (bookDTO.getGender() == null) {
            throw new BookCreationException("Veuillez ajouter un genre à l'ouvrage");
        }

        if (bookDTO.getPicture() == null) {
            throw new BookCreationException("Veuillez ajouter une photo de la couverture de l'ouvrage");
        }

        if (bookDTO.getTitle() == null) {
            throw new BookCreationException("Veuillez renseigner le titre de l'ouvrage");
        }
        Book book = bookMapper.bookDtoToBook(bookDTO);

        return bookRepository.save(book);
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        Book book = getBook(bookDTO.getId());
        if (book == null) throw new BookNotFoundException("Le livre recherché n'a pas été trouvé");
        bookMapper.updateBookFromBookDTO(bookDTO, book);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
