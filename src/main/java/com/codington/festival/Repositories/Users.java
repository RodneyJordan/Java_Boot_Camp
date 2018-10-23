package com.codington.festival.Repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.*;
import java.util.Optional;
import com.codington.festival.Models.*;



@Repository
public interface Users extends CrudRepository<User,Integer> {
	User findByEmail(String email);
	
}
