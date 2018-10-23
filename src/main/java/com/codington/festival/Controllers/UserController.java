/*-package com.codington.festival.Controllers;

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

	@GetMapping("/login")
	public String showLoginform() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationpage(Model model) {
		model.addAttribute("user", new User());
		return "registration";
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
		return "login";
	}
		
}*/
package com.codington.festival.Controllers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codington.festival.Models.User;
import com.codington.festival.Repositories.Users;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;


    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }
}
