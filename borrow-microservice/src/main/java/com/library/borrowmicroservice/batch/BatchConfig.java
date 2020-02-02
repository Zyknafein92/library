package com.library.borrowmicroservice.batch;


import com.library.borrowmicroservice.model.Book;
import com.library.borrowmicroservice.model.Borrow;
import com.library.borrowmicroservice.model.Email;
import com.library.borrowmicroservice.model.User;
import com.library.borrowmicroservice.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;



@Component
public class BatchConfig {
    //todo : retirer spring batch du pom
    List<Borrow> borrowsOutDated = new ArrayList<>();
    Email email = new Email();
    User user = new User();
    Book book = new Book();

    @Autowired
    BorrowService borrowService;
    @Autowired
    EmailConfig emailConfig;

//    @Scheduled(cron= "0 0 0 * * *") //tous les jours à minuit.
//    @Scheduled(fixedDelay = 60000) // toutes les minutes
    public void runBatch() {

        borrowsOutDated =  getAllBorrowsOutdated();

        if(borrowsOutDated.size() > 0) {

            for (Borrow borrow : borrowsOutDated) {
                user = DatabaseConnect.getUserFromDB(borrow.getUserID());
                book = DatabaseConnect.getBookFromDB(borrow.getBookID());
                email = createEmailInformations(user,book,borrow);

                if(email.getIsExtend()) emailConfig.sendEmailwithoutExtension(email);
                else emailConfig.sendEmailwithExtension(email);
            }

        }

    }

    private Email createEmailInformations (User user, Book book, Borrow borrow) {

        Email emailToSend = new Email();

        emailToSend.setFirstName(user.getFirstName());
        emailToSend.setLastName(user.getLastName());
        emailToSend.setEmailUser(user.getEmail());
        emailToSend.setBookTitle(book.getTitle());
        emailToSend.setIsExtend(borrow.getIsExtend());
        emailToSend.setDateEnd(borrow.getDateEnd());
        emailToSend.setDateExtend(borrow.getDateExtend());

        return emailToSend;
    }

    public List<Borrow> getAllBorrowsOutdated () {
        return borrowService.getOutDatedBorrow();
    }

}
