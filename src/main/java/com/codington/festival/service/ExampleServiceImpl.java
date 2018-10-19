package com.codington.festival.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codington.festival.example.Example;
import com.codington.festival.example.ExampleDAO;

@Transactional
@Component
public class ExampleServiceImpl implements ExampleFacade {
	
	@Autowired
	private ExampleDAO exampleDAO;

	public List<Example> getAllExamples() {
		return exampleDAO.showAllExamples();
	}
}