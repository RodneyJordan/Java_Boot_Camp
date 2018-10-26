package com.codington.festival.Controllers;

import org.postgresql.util.PSQLException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codington.festival.Models.ParkingPass;
import com.codington.festival.Models.User;
import com.codington.festival.Repositories.ParkingPassRepository;

@Controller
public class ParkingPassController {
	private ParkingPassRepository parkingRepo;
	
	public ParkingPassController(ParkingPassRepository parkingRepo) {
		this.parkingRepo = parkingRepo;
	}


	    @GetMapping("/buyParkingPass")
	    public String showParkingForm(Model model) {
	    	model.addAttribute("parkingPass", new ParkingPass());
	        return "buyParkingPass";
	    }
	    
	    @PostMapping("/buyParkingPass")
	    public String getParkingInfo(@ModelAttribute ParkingPass parkingPass, Model model) {
			User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (parkingRepo.getParkingPassesPerUser(currentUser.getId()) >= 2) {
					model.addAttribute("alreadyHave2", true);
					return "buyParkingPass";
				} else if (parkingRepo.checkForPlate(parkingPass.getPlate()) > 0) {
					model.addAttribute("plateUsed", true);
					return "buyParkingPass";
				} else {
					return"redirect:profile";
				}
				
			} 
	    
	    @PostMapping("/deleteParkingPass")
	    public String getParkingInfo(@RequestParam(name="deletePlate") String plateToDelete) {
	    	System.out.println("plateTODelete: " + plateToDelete);
			parkingRepo.deletePlate(plateToDelete);
			return "redirect:/profile";
			} 
		
		

	   
	
	
	
}