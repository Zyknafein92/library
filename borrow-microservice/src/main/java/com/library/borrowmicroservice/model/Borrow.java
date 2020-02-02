package com.library.borrowmicroservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name= "borrow", schema="public")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Borrow {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="borrow_id")
    private Long id;

    @Column(name="user_id")
    private String userID;

    @Column(name="book_id")
    private String bookID;

    @Column(name="date_start")
    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "CET", locale = "fr-FR")
    @Temporal(TemporalType.DATE)
    private Date dateStart;

    @Column(name="date_end")
    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "CET", locale = "fr-FR")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    @Column(name="date_extend")
    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "CET", locale = "fr-FR")
    @Temporal(TemporalType.DATE)
    private Date dateExtend;

    @Column(name="is_extend")
    private Boolean isExtend;

}
