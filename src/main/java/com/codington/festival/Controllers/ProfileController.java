package com.codington.festival.Controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		if(!userSvc.isLoggedIn()) {
			return "redirect:register";
		}
		model.addAttribute("loggedIn", userSvc.isLoggedIn());
		model.addAttribute("name",userSvc.currentUser().getFirst_name());
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("name", userSvc.currentUser().getFirst_name());
		model.addAttribute("volunteer", userSvc.currentUser().getVolunteer());
		model.addAttribute("ticketNumber", 10 - ticketRepo.ticketNumber(currentUser.getId()));
		model.addAttribute("numOfTickets", ticketRepo.getTicketsPerUser(currentUser.getId()));
		System.out.println("num of tickets" + ticketRepo.getTicketsPerUser(currentUser.getId()));
		model.addAttribute("numOfParking", parkRepo.getParkingPassesPerUser(currentUser.getId()));
		System.out.println(ticketRepo.findAllById(currentUser.getId()));
		model.addAttribute("showTickets", ticketRepo.findAllById(currentUser.getId()));
		model.addAttribute("platesRegistered", parkRepo.getPlatesPerUser(currentUser.getId()));

		return "profile";
	}
	
	@PostMapping("/volunteerbox")
	public String volunSwitch(@ModelAttribute User user) {
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(currentUser.getVolunteer() == true) {
			currentUser.setVolunteer(false);
			System.out.println("canceling volunteership");

		}else if(currentUser.getVolunteer() == false){
			currentUser.setVolunteer(true);
			System.out.println("now volunteering");

		}
		return "redirect:/profile";
	}

}
