package com.codington.festival.Controllers;

import java.util.Random;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codington.festival.Models.Ticket;
import com.codington.festival.Models.User;
import com.codington.festival.Repositories.TicketRepository;
import com.codington.festival.Repositories.Users;

import java.util.Random;

@Controller
public class TicketController {
	
	private TicketRepository ticketRepo;
	private Users userRepo;
	
	public TicketController(TicketRepository ticketRepo, Users userRepo) {
		this.ticketRepo = ticketRepo;
		this.userRepo = userRepo;
	}
	

	@GetMapping("/ticketbuy")
	public String showBuyTickets(Model model) {
		model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return "ticketbuy";
	}
	
	@PostMapping("/profile")
	public String buyTickets(
			@RequestParam(name = "ticket_add_sub") int number) {
			User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			for (int i = number; i < number; i++) {
				Ticket ticket = new Ticket();
				Random rand = new Random();
				ticket.setId(current.getId());
				ticket.setTicketNum(rand.nextInt(25) + 1);
			}
			
		return "redirect:/profile";
	}
}
