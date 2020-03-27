package com.muskan.bookmyshowmuskan.repository;

import com.muskan.bookmyshowmuskan.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


}
