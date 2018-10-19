package com.codington.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codington.example.Example;
import com.codington.example.ExampleDAO;

@Transactional
@Component
public class ExampleService {
	
	@Autowired
	private ExampleDAO exampleDAO;

	public List<Example> getAllExamples() {
		return exampleDAO.showAllExamples();
	}
}