package com.codington.festival.Repositories;
import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codington.festival.Models.ParkingPass;
import com.codington.festival.Models.Ticket;
import com.codington.festival.Models.User;


@Repository
public interface ParkingPassRepository extends CrudRepository<ParkingPass, Long> {
	
	@Query(value = "SELECT count(*) FROM parking_passes WHERE user_id = ?1", nativeQuery = true)
	int getParkingPassesPerUser(long userId);
	
	@Query(value = "SELECT count(license_plate) FROM parking_passes WHERE license_plate = ?1", nativeQuery = true)
	int checkForPlate(String plate);
	
	@Query(value = "SELECT license_plate FROM parking_passes WHERE user_id = ?1", nativeQuery = true)
	List<String> getPlatesPerUser(long userId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM parking_passes WHERE license_plate = ?1", nativeQuery = true)
	void deletePlate(String plate);
	
	
	
}
