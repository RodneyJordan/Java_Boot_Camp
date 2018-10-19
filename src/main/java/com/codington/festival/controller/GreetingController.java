package com.codington.festival.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class GreetingController {
	private static final Logger LOGGER = LogManager.getLogger(GreetingController.class);

	@RequestMapping(value="/greet")
	public ModelAndView greet(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	LOGGER.info("greetings");
        model.addAttribute("name", name);
        ModelAndView mv = new ModelAndView();
		mv.setViewName("greeting");
		return mv;
    }
}