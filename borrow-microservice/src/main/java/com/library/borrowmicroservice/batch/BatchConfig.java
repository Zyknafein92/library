package com.library.borrowmicroservice.batch;


import com.library.borrowmicroservice.model.Book;
import com.library.borrowmicroservice.model.Borrow;
import com.library.borrowmicroservice.model.User;
import com.library.borrowmicroservice.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;


public class BatchConfig {

    List<Book> listbooks = new ArrayList<>();
    List<Borrow> listBorrows = new ArrayList<>();

    @Autowired
    BorrowRepository borrowRepository;

    public List<Borrow> getAllBorrowsOutdated () {
        return borrowRepository.findAll();
    }

    public List<User> getListUserByID () {
        List<Borrow> borrows = getAllBorrowsOutdated();
        List<String> usersID = new ArrayList<>();

        for (Borrow borrow: borrows) {
              usersID.add(borrow.getUserID());
            }
        return null;
    }

    public List<Book> getListBookByID () {
        return null;
    }
    // Passer en revue la bdd.
    // Chercher les livres dont date end non extend et extend dépassé.
    // Ajouter ces utilisateurs a list
    // passer la list dans le batch 6> envoi e-mail toutes les 24h.
}
