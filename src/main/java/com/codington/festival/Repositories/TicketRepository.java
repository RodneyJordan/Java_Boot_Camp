package com.codington.festival.Repositories;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codington.festival.Models.Ticket;
import com.codington.festival.Models.User;


@Repository
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
