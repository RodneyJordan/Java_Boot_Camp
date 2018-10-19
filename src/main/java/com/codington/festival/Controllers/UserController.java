package com.codington.festival.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.codington.festival.Models.User;

@Controller
public class UserController {
	@PostMapping("/register")
	public String register(User user) {
		System.out.println("First Name: " + user.getFirst_name());
		System.out.println("Last Name: " + user.getLast_name());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: " + user.getPassword());
		return null;
	}
}
