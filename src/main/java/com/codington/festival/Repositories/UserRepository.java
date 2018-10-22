package com.codington.festival.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.*;
import java.util.Optional;
import com.codington.festival.Models.*;



@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
