package com.muskan.bookmyshowmuskan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date showTime;

    @Column
    int screenNumber;

    @Column
    //Set<Integer> seatNumber;
    Integer seatcount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_theatre_Id")
    Theatre theatre;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_movie_Id")
    Movie movie;

    //@OneToMany(mappedBy = "movieShow")
    @OneToMany
    @JsonIgnore
    List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "movieShow", cascade = CascadeType.ALL)
    List<Seat> seats;

    @Override
    public String toString() {
        return null;
    }
}
