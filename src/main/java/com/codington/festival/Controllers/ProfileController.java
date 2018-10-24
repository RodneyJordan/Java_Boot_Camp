package com.codington.festival.Controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codington.festival.Repositories.Users;
import com.codington.festival.services.UserService;

@Controller
public class ProfileController {
	
    private Users users;
    private PasswordEncoder passwordEncoder;
    private UserService userSvc;
    

    public ProfileController(Users users, PasswordEncoder passwordEncoder, UserService userSvc) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
    }
	
	@GetMapping("/profile")
	public String showUserProfile(Model model) {
		if(userSvc.isLoggedIn()) {
		model.addAttribute("user", userSvc.currentUser());
		}
		return "profile";
	}
	
	
}
