package com.codington.festival.Repositories;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codington.festival.Models.Ticket;



public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	@Query(value = "SELECT COUNT(user_id) FROM ticket WHERE user_id = ?1 GROUP BY user_id")
	int getTotalTickets(long userId);
	
	@Query(value = "SELECT id FROM tickets WHERE user_id = ?1 LIMIT ?2", nativeQuery = true)
    List<BigInteger> getTicketIds(long userId, int limit);
	
	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM tickets WHERE id = ?1", nativeQuery = true)
	 void deleteTicket(BigInteger ticketId);

}
