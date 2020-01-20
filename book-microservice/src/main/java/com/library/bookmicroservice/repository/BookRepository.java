package com.library.bookmicroservice.repository;

import com.library.bookmicroservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select distinct b from Book b where b.title like :criteria or b.author like :criteria or b.gender like :criteria")
    List<Book> searchBook(@Param("criteria") String criteria);
   //to lowercase -> voir la recherche Query.

}
