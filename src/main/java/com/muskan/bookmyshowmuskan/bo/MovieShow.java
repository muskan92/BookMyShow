package com.muskan.bookmyshowmuskan.bo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    Date showTime;

    @Column
    int screenNumber;

    @Column
    //Set<Integer> seatNumber;
    Integer seatcount;

    @ManyToOne
    @JoinColumn(name = "theatre_Id")
    Theatre theatre;

    @ManyToOne
    Movie movie;

    //@OneToMany(mappedBy = "movieShow")
    @OneToMany
    List<Ticket> tickets = new ArrayList<>();

}