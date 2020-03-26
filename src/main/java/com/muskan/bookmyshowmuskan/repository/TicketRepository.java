package com.muskan.bookmyshowmuskan.repository;

import com.muskan.bookmyshowmuskan.bo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


}
