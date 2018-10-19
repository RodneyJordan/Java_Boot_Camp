package com.codington.festival.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codington.festival.example.Example;
import com.codington.festival.service.ExampleServiceImpl;

@Controller
public class ExampleController {
	private final static Logger logger = LogManager.getLogger(ExampleController.class);
	
	@Autowired
	ExampleServiceImpl exampleService;
	
	@GetMapping("/catalog.htm")
	public ModelAndView getAvailableExamples(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Hewwo?");

		if (request == null || response == null) {
			logger.info("request or response not valid in getAvailableExamples() ");
			throw new Exception(
					"Error in Transaction, Please re-Try. for more information check Logfile in C:\\ folder",
					new NullPointerException());
		}
		
		List<Example> exampleList = new ArrayList<Example>();
		exampleList = exampleService.getAllExamples();

		logger.info("All Examples are listed :" + exampleList);

		ModelAndView mv = new ModelAndView();
		mv.addObject("allExamples", exampleList);
		mv.setViewName("examplecatalog");
		return mv;
	}
}
