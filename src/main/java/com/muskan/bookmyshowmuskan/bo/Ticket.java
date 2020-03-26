package com.muskan.bookmyshowmuskan.bo;

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
    Date showTime;

    @Column
    String seatNumber;

    @Column
    String qrCode;
}
