package com.codington.festival.Controllers;

import org.springframework.stereotype.Controller;
import com.codington.festival.Models.*;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codington.festival.Models.User;

@Controller
public class UserController {
	
	@GetMapping("/register")
	public String showRegistrationpage(Model model) {
		model.addAttribute("user", new User());
		System.out.println("REGISTER CONTROLLER WORKS!");
		return "register";
	}
	
	

	@PostMapping("/register")
	public String register(User user) {
		System.out.println("First Name: " + user.getFirst_name());
		System.out.println("Last Name: " + user.getLast_name());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: " + user.getPassword());
		return null;
	}
	
}

