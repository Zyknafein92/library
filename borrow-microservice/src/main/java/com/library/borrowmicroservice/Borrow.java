package com.library.borrowmicroservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name= "borrow", schema="public")
public class Borrow {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="borrow_id")
    private Long id;

    @Column(name="user_id")
    private String userID; //todo : Voir avec l'id seulement si ca passe (Alexandre a dit vas-y test !!! xD)

    @Column(name="book_id")
    private String bookID;

    @Column(name="date_start_borrow")
    private LocalDateTime dateStart;

    @Column(name="date_end")
    private LocalDateTime dateEnd;

    @Column(name="date_extend")
    private LocalDateTime dateExtend;

    @Column(name="is_extend")
    private Boolean isExtend;
}
