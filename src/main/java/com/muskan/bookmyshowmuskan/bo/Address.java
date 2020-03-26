package com.muskan.bookmyshowmuskan.bo;

import lombok.Builder;
import lombok.Data;
import com.muskan.bookmyshowmuskan.bo.User;

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
