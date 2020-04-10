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
    @JoinColumn(name = "fk_movie_Id")
    Movie movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_theatre_Id")
    Theatre theatre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_user_Id")
    User user;
}
