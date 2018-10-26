package com.codington.festival.Controllers;
import java.lang.reflect.InvocationTargetException;

import org.springframework.aop.AopInvocationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codington.festival.Models.Ticket;
import com.codington.festival.Models.User;
import com.codington.festival.Repositories.TicketRepository;
import com.codington.festival.Repositories.Users;
import com.codington.festival.services.UserService;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private UserService userSvc;
    private TicketRepository ticketRepo;


    public UserController(Users users, PasswordEncoder passwordEncoder, UserService userSvc, TicketRepository ticketRepo) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
        this.ticketRepo = ticketRepo;
    }
    
    @GetMapping("/")
    public String showInfoPage(Model model) {
    	model.addAttribute("loggedIn", userSvc.isLoggedIn());
    	model.addAttribute("totalSold", ticketRepo.getTotalSoldGlobally());

    	return "index";
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
        System.out.println(user.getEmail());
        System.out.println(user.getFirst_name());
        System.out.println(user.getLast_name());
        System.out.println(user.getPassword());
        System.out.println(user.getVolunteer());
        return "redirect:/login";
    }
    
    @GetMapping("/info")
    public String showInfoPage() {
    	return "info";
    }
      
    @GetMapping("/contact")
    public String showContactPage() {
    	return "contact";
    }
    
    @GetMapping("/faq")
    public String showFaqPage() {
    	return "faq";
    }
    
    
}
