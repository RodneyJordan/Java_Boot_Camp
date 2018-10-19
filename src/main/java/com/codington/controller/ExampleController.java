package com.codington.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codington.example.Example;
import com.codington.service.ExampleService;

public class ExampleController {
	private static final Logger LOGGER = LogManager.getLogger(ExampleController.class);
	
	@Autowired
	ExampleService exampleService;
	
	@RequestMapping("/catalog.htm")
	public ModelAndView getAvailableExamples(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (request == null || response == null) {
			LOGGER.info("request or response not valid in GETAVAILABLEEVENTS METHOD ");
			throw new Exception(
					"Error in Transaction, Please re-Try. for more information check Logfile in C:\\ folder",
					new NullPointerException());
		}
		
		List<Example> exampleList = new ArrayList<Example>();
		System.err.println("A");
		exampleList = exampleService.getAllExamples();
		System.err.println("B");

		LOGGER.info("All Events are listed :" + exampleList);

		ModelAndView mv = new ModelAndView();
		mv.addObject("allEvents", exampleList);
		mv.setViewName("/exampleCatalog.jsp");
		return mv;
	}
}
