package com.library.borrowmicroservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name= "borrow", schema="public")
public class Borrow {

    // Données nécessaires supplémentaires : nom, prénom, email, titre du livre,

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="borrow_id")
    private Long id;

    @Column(name="user_id")
    private String userID;

    @Column(name="book_id")
    private String bookID;

    @Column(name="date_start_borrow")
    @Temporal(TemporalType.DATE)
    private LocalDateTime dateStart;

    @Column(name="date_end")
    @Temporal(TemporalType.DATE)
    private LocalDateTime dateEnd;

    @Column(name="date_extend")
    @Temporal(TemporalType.DATE)
    private LocalDateTime dateExtend;

    @Column(name="is_extend")
    private Boolean isExtend;
}
