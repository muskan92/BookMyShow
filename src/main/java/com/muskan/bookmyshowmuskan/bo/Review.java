package com.muskan.bookmyshowmuskan.bo;

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
    @JoinColumn(name = "fk_movieId")
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "fk_theatreId")
    Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "fk_userId")
    User user;
}
