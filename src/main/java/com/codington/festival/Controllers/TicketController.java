package com.codington.festival.Controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codington.festival.Models.User;
import com.codington.festival.Repositories.TicketRepository;

@Controller
public class TicketController {
	
	private TicketRepository ticketRepo;
	
	public TicketController(TicketRepository ticketRepo) {
		this.ticketRepo = ticketRepo;
	}
	
	@PostMapping("/refundTickets")
	public String deleteTicket(@RequestParam(name = "numOfTickets") String tickets, Model model) {
		int ticketsToDelete = Integer.parseInt(tickets);
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int totalTickets = ticketRepo.getTotalTickets(currentUser.getId());
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
