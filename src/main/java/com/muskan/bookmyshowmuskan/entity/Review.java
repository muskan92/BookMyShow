package com.muskan.bookmyshowmuskan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_movieId")
    Movie movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_theatreId")
    Theatre theatre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_userId")
    User user;
}
