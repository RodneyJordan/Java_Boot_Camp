package com.codington.festival.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SponsorController {

	@GetMapping("/sponsors")
	public String showSponsorPage() {
		return "sponsors";
	}
		
}
