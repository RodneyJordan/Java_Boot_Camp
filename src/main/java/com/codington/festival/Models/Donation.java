package com.codington.festival.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Donation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "amount", nullable = false, unique = true)
	private double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private int charity_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCharity_id() {
		return charity_id;
	}

	public void setCharity_id(int charity_id) {
		this.charity_id = charity_id;
	}
	
	
}
