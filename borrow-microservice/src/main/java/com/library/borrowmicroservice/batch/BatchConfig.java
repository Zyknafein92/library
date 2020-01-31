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


    @Scheduled(fixedDelay = 60000)
    public void runBatch() {

        borrowsOutDated =  getAllBorrowsOutdated();

        if(borrowsOutDated.size() > 0) {

            for (Borrow borrow : borrowsOutDated) {
                System.out.println("Book to search:" + borrow.getBookID());
                System.out.println("User to search:" +borrow.getUserID());
                user = DatabaseConnect.getUserFromDB(borrow.getUserID());
                book = DatabaseConnect.getBookFromDB(borrow.getBookID());
                System.out.println("Book to search:" + book);
                System.out.println("User to search:" + user);
                email = createEmailInformations(user,book,borrow);

                if(email.getIsExtend()) emailConfig.sendEmailwithoutExtension(email);
                else emailConfig.sendEmailwithExtension(email);
            }

        }

    }

    private Email createEmailInformations (User user, Book book, Borrow borrow) {

        System.out.println("User :" + user);
        System.out.println("Book :" +book);
        System.out.println("Borrow: " +borrow);

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


//    private List<Mail> createMailInformations (List<User> users, List<Book> books, List<Borrow> borrowsOutDated) {
//
//        System.out.println("Users :" + users);
//        System.out.println("Books :" +books);
//        System.out.println("Borrows: " +borrowsOutDated);
//
//
//        for(int i = 0; i < borrowsOutDated.size(); i++) {
//            Mail mail = new Mail();
//
//            mail.setFirstName(users.get(i).getFirstName());
//            mail.setLastName(users.get(i).getLastName());
//            mail.setEmailUser(users.get(i).getEmail());
//            mail.setBookTitle(books.get(i).getTitle());
//            mail.setIsExtend(borrowsOutDated.get(i).getIsExtend());
//            mail.setDateEnd(borrowsOutDated.get(i).getDateEnd());
//            mail.setDateExtend(borrowsOutDated.get(i).getDateExtend());
//            emailToSend.add(mail);
//        }
//
//        return emailToSend;
//    }





    public List<Borrow> getAllBorrowsOutdated () {
        return borrowService.getOutDatedBorrow();
    }

}
