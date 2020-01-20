package com.library.borrowmicroservice.repository;

import com.library.borrowmicroservice.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;


@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {


    List<Borrow> findAllById(Long userID);

    @Query("select distinct b from Borrow b where current_date < b.dateEnd and b.isExtend = TRUE or current_date < b.dateExtend")
    List<Borrow> findAllBorrowOutDated(Date dateEnd, Date dateExtend, Boolean isExtend);
}
