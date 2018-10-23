package com.codington.festival.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codington.festival.Models.User;
import com.codington.festival.Models.UserWithRoles;
import com.codington.festival.Repositories.Users;

@Service
public class UserDetailsLoader implements UserDetailsService {
	 private final Users users;

	    public UserDetailsLoader(Users users) {
	        this.users = users;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = users.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException("No user found for " + email);
	        }
	        return new UserWithRoles(user);
	    }
}
