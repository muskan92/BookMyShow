package com.muskan.bookmyshowmuskan.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String title;

    @Column
    String characterName;

    @Column
    float rating;

    @Column
    Date releaseDate;

    @Column
    String Description;

    @Column
    String trailerUrl;

    @Column
    boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    List<Review> reviews = new ArrayList<>();

}
