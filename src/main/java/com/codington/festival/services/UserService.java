package com.codington.festival.services;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.codington.festival.Models.User;
import com.codington.festival.Repositories.Users;

@Service
public class UserService {
	
	Users users;
	
	public UserService(Users users) {
		this.users = users;
	}
	
	   public Optional<User> currentUser(){
	        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        return users.findById(user.getId());
	    }

}
