package com.library.borrowmicroservice.services;

import com.library.borrowmicroservice.model.Borrow;

import java.util.List;

public interface BorrowService {

    List<Borrow> findBorrowById(Long id);

    Borrow getBorrow(Long id);

    Borrow createBorrow(BorrowDTO borrowDTO);

    Borrow extendBorrow(Long id);

    void updateBorrow(BorrowDTO borrowDTO);

    void deleteBorrow(Long id);
}
