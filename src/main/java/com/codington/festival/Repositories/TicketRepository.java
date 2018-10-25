package com.codington.festival.Repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codington.festival.Models.Ticket;
import com.codington.festival.Models.User;

import antlr.collections.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer> {
		
}
