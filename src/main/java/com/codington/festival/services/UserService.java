package com.codington.festival.services;

import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
	
	   public User currentUser() {
	        return  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        
	    }
	   
	   public boolean isLoggedIn() {
	        boolean isAnonymousUser =
	                SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
	        return ! isAnonymousUser;
	    }

}
