package com.muskan.bookmyshowmuskan.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String name;

    @OneToOne
    Address address;

}
