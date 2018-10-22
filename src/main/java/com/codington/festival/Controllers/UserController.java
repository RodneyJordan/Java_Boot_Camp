package com.codington.festival.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codington.festival.Models.User;
import com.codington.festival.Repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	public UserRepository userRepo;

	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/dumb")
	public String showLoginform() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationpage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(User user) {
		userRepo.save(user);
		return "success";
	}

	@GetMapping("/profile")
	public String showProfile() {
		return "profile";

	}
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
		
}
