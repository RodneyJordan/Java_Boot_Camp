package com.codington.festival.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codington.festival.Models.User;
import com.codington.festival.Models.Vendor;
import com.codington.festival.Repositories.Users;
import com.codington.festival.Repositories.VendorRepository;;

@Controller
public class VendorController {
	
	private Users users;
	private Vendor vendors;
	private VendorRepository vendorRepo;
	
	public VendorController (VendorRepository vendorRepo, Users users) {
		this.vendorRepo = vendorRepo;
		this.users = users;
	}
	
	@GetMapping("/vendors")
	public String showVendorsPage(Model model) {
		model.addAttribute("showVendors", vendorRepo.findAllByApproved(true));
		return "vendors";
	}

	
	@PostMapping("/vendors")
	public String addVendor (
			@RequestParam(name = "email") String email,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "url") String url) {
		Vendor vendor = new Vendor();
		vendor.setEmail(email);
		vendor.setName(name);
		vendor.setPhone(phone);
		vendor.setUrl(url);
		vendor.setApproved(true);;
		
		vendorRepo.save(vendor);
		
		return "redirect:vendors";
	}
	
}
