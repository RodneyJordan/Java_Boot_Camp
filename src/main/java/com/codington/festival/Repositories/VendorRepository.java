package com.codington.festival.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codington.festival.Models.Vendor;

@Repository
public interface VendorRepository extends CrudRepository <Vendor, Long> {
	
	@Query(value = "SELECT * FROM vendor WHERE approved = ?1", nativeQuery = true)
	List<Vendor> findAllByApproved(boolean approved);

}
