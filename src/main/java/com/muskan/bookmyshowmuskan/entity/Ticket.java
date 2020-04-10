package com.muskan.bookmyshowmuskan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String movieName;

    //@ManyToOne
    @Column
    String theatreName;

    @Column
    int screenNumber;

    @Column
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date showTime;

    @Column
    String seatNumber;

    @Column
    String qrCode;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_user_Id")
    User user;
}
