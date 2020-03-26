package com.muskan.bookmyshowmuskan.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;

    @Column
    float rating;

    @OneToOne
    Owner owner;

    @OneToOne
    Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "theatre")
    List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "theatre")
    List<MovieShow> movieShow = new ArrayList<>();

}
