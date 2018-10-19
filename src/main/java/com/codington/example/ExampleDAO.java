package com.codington.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.codington.controller.ExampleController;

@Component
public class ExampleDAO {
	private static final Logger LOGGER = LogManager.getLogger(ExampleController.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public ExampleDAO() {

	}

	public List<Example> showAllExamples() throws NoResultException,
			PersistenceException {
		Query query = entityManager.createQuery("SELECT e from Example e");
		List exampleList = (ArrayList<Example>) query.getResultList();
		if(exampleList.isEmpty()){
			LOGGER.info("No events");
			throw new NoResultException("No events");
		}

		return exampleList;
	}
}
