package com.library.borrowmicroservice.repository;

import com.library.borrowmicroservice.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {

    List<Borrow> findAllById(Long userID);

}
