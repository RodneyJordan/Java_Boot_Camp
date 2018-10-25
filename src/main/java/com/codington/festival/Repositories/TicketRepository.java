package com.codington.festival.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.codington.festival.Models.Ticket;
import com.codington.festival.Models.User;

import antlr.collections.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	@Query(value = "SELECT * FROM ticket WHERE user_id = ?1", nativeQuery = true)
	List<Ticket> findAllById(long Id);
	
	@Query(value = "SELECT COUNT(*) FROM ticket WHERE user_id = ?1", nativeQuery = true)
	Long ticketNumber(long id);
	
	@Query(value = "SELECT count(*) FROM ticket", nativeQuery = true)
	int getTotalSoldGlobally();
	
	@Query(value = "SELECT count(*) FROM ticket WHERE user_id = ?1", nativeQuery = true)
	int getTicketsPerUser(long userId);
	
	@Query(value = "SELECT id FROM ticket WHERE user_id = ?1 LIMIT ?2", nativeQuery = true)
    List<BigInteger> getTicketIds(long userId, int limit);
	
	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM ticket WHERE id = ?1", nativeQuery = true)
	 void deleteTicket(BigInteger ticketId);
}
