package com.codington.festival.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codington.festival.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
