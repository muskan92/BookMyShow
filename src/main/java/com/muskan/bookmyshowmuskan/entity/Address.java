package com.muskan.bookmyshowmuskan.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
//@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(unique = true)
    @NotNull
    String building;

    @Column
    String area;

    @Column
    String city;

    @Column
    @NotNull
    int pin;

    @Column
    String state;


}
