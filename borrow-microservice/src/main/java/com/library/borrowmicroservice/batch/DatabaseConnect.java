package com.library.borrowmicroservice.batch;

import com.library.borrowmicroservice.model.Book;
import com.library.borrowmicroservice.model.Borrow;
import com.library.borrowmicroservice.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

@Component
public class DatabaseConnect {

    // Database Config
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_USER_URL = "jdbc:postgresql://localhost:5432/bibliotheque-user";
    static final String DB_BOOK_URL = "jdbc:postgresql://localhost:5432/bibliotheque-book";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "admin";


//    public static List<User> getUsersFromDB(List<Borrow> borrowList)  {
//        List<User> userList = new ArrayList<>();
//        User user = new User();
//
//        try (Connection connection = DriverManager.getConnection(DB_USER_URL, USER, PASS)) {
//            Class.forName(JDBC_DRIVER);
//            Statement statement = connection.createStatement();
//            String borrowUserList = borrowList.stream().map(Borrow::getUserID).collect(joining(","));
//            System.out.println("Looking in db for :" +borrowUserList);
//            ResultSet rs = statement.executeQuery("Select u.user_id, u.first_name, u.last_name, u.email from public.user u where u.user_id in ("+borrowUserList+")");
//            while (rs.next()){
//                user.setFirstName(rs.getString("first_name"));
//                user.setLastName(rs.getString("last_name"));
//                user.setEmail(rs.getString("email"));
//                System.out.println(rs);
//                userList.add(user);
//            }
//
//            rs.close();
//
//        } catch (SQLException e) {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Fail to load driver");
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//
//    public static List<Book> getBooksFromDB(List<Borrow> borrowList) {
//        List<Book> bookList = new ArrayList<>();
//        Book book = new Book();
//
//        try (Connection connection = DriverManager.getConnection(DB_BOOK_URL, USER, PASS)) {
//            Class.forName(JDBC_DRIVER);
//            Statement statement = connection.createStatement();
//            String borrowBookList = borrowList.stream().map(Borrow::getBookID).collect(joining(","));
//            System.out.println("Looking in db for :" +borrowBookList);
//            ResultSet rs = statement.executeQuery("Select b.book_id, b.title, b.library_id from public.book b where b.book_id in ("+borrowBookList+")");
//            while (rs.next()){
//                book.setId(rs.getLong("book_id"));
//                book.setTitle(rs.getString("title"));
//                bookList.add(book);
//            }
//
//            rs.close();
//
//        } catch (SQLException e) {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Fail to load driver");
//            e.printStackTrace();
//        }
//        return bookList;
//
//    }

    public static Book getBookFromDB(String bookID) {

        Book book = new Book();

        try (Connection connection = DriverManager.getConnection(DB_BOOK_URL, USER, PASS)) {
            Class.forName(JDBC_DRIVER);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select b.book_id, b.title, b.library_id from public.book b where b.book_id in (" + bookID + ")");
            while (rs.next()) {
                book.setId(rs.getLong("book_id"));
                book.setTitle(rs.getString("title"));
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Fail to load driver");
            e.printStackTrace();
        }
        return book;
    }


    public static User getUserFromDB(String userID) {

        User user = new User();
        try (Connection connection = DriverManager.getConnection(DB_USER_URL, USER, PASS)) {
            Class.forName(JDBC_DRIVER);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select u.user_id, u.first_name, u.last_name, u.email from public.user u where u.user_id in (" + userID + ")");
            while (rs.next()){
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Fail to load driver");
            e.printStackTrace();
        }
        return user;
    }
}

