package com.codington.festival.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codington.festival.Models.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

}
