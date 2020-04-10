package com.muskan.bookmyshowmuskan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int seatNumber;

    public Seat() {
    }

    @Enumerated(EnumType.STRING)
    SeatType seatType;

    boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "fk_movieShow_Id")
    @JsonIgnore
    MovieShow movieShow;

    public Seat(int seatNumber, SeatType seatType, boolean isAvailable, MovieShow movieShow) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
        this.movieShow = movieShow;
    }

    public enum SeatType{
        GOLD,PLATINUM;

    }
}
