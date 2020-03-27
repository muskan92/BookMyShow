package com.muskan.bookmyshowmuskan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String userName;

    @OneToOne(cascade = {CascadeType.ALL})
    Address userAddress;

    @Column(unique = true)
    @NotNull
    String email;

    @Column
    Date dob;

    @Column
    @NotNull
    String password;

    @OneToMany(mappedBy = "user")
    List<Ticket> ticketList;

    //@JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Review> reviews = new ArrayList<>();


  /*  Tables_in_bookmyshow   |
            +------------------------+
            | address                |
            | hibernate_sequence     |
            | movie                  |
            | movie_review_list      |
            | movie_show             |
            | movie_show_ticket_list |
            | owner                  |
            | review                 |
            | theatre                |
            | theatre_review_list    |
            | ticket                 |
            | user                   |
            | user_ticket_list
*/

}
