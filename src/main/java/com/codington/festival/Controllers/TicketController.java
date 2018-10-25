package com.codington.festival.Controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	
	@PostMapping("/ticketbuy")
	public String buyTickets(
			@RequestParam(name = "ticket_add_sub") int number) {
			User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();
			for (int i = 1; i <= number; i++) {
				String rand = UUID.randomUUID().toString();
				Ticket ticket = new Ticket();		
				ticket.setUser(current);
//				ticket.setId(current.getId());
				ticket.setTicketNum(rand);
				tickets.add(ticket);			
			}

			for (Ticket tick : tickets) {
				ticketRepo.save(tick);
			}	
		return "redirect:/profile";
	}
	
	@PostMapping("/refundTickets")
	public String deleteTicket(@RequestParam(name = "numOfTickets") String tickets, Model model) {
		int ticketsToDelete = Integer.parseInt(tickets);
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int totalTickets = ticketRepo.getTicketsPerUser(currentUser.getId());
		System.out.println("total tickets" + ticketRepo.getTicketsPerUser(currentUser.getId()));
		if (ticketsToDelete <= 0 || (totalTickets - ticketsToDelete) < 0) {
			model.addAttribute("negativeNum", true);
		} else {
			List<BigInteger> idsToDelete = ticketRepo.getTicketIds(currentUser.getId(), ticketsToDelete);
			idsToDelete.forEach(t -> ticketRepo.deleteTicket(t));
			model.addAttribute("numDeleted", tickets);
		}
		
		return "profile";
	}
	
	
	
	
	
	
	
}
;