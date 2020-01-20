package com.library.borrowmicroservice.batch;


import com.library.borrowmicroservice.model.Borrow;
import com.library.borrowmicroservice.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BatchConfig {

    @Autowired
    BorrowRepository borrowRepository;

    public List<Borrow> getAllBorrowsOutdated () {
        return borrowRepository.findAll();
    }

    // Passer en revue la bdd.
    // Chercher les livres dont date end non extend et extend dépassé.
    // Ajouter ces utilisateurs a list
    // passer la list dans le batch 6> envoi e-mail toutes les 24h.
}
