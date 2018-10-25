package com.codington.festival.Controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codington.festival.Models.User;
import com.codington.festival.Repositories.ParkingPassRepository;
import com.codington.festival.Repositories.TicketRepository;
import com.codington.festival.Repositories.Users;
import com.codington.festival.services.UserService;

@Controller
public class ProfileController {
	
    private Users users;
    private PasswordEncoder passwordEncoder;
    private UserService userSvc;
    private TicketRepository ticketRepo;
    private ParkingPassRepository parkRepo;
    

    public ProfileController(Users users, PasswordEncoder passwordEncoder, UserService userSvc, TicketRepository ticketRepo, ParkingPassRepository parkRepo) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.userSvc = userSvc;
        this.ticketRepo = ticketRepo;
        this.parkRepo = parkRepo;
    }
	
	@GetMapping("/profile")
	public String showUserProfile(Model model) {
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("name", userSvc.currentUser().getFirst_name());
		model.addAttribute("ticketNumber", 10 - ticketRepo.ticketNumber(currentUser.getId()));
		model.addAttribute("numOfTickets", ticketRepo.getTicketsPerUser(currentUser.getId()));
		model.addAttribute("numOfParking", parkRepo.getParkingPassesPerUser(currentUser.getId()));
		System.out.println(ticketRepo.findAllById(currentUser.getId()));
		return "profile";
	}
}
