package com.codington.festival.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.codington.festival.Models.Ticket;

import antlr.collections.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
//	List<Ticket> findAllById(long Id);
//	
//	@Query(value = "SELECT id FROM tickets WHERE user_id = ?1 LIMIT ?2", nativeQuery = true)
//    List<BigInteger> getTicketIds(long userId, int limit);
//	
//	 @Transactional
//	 @Modifying
//	 @Query(value = "DELETE FROM tickets WHERE id = ?1", nativeQuery = true)
//	 void deleteTicket(BigInteger ticketId);


}
