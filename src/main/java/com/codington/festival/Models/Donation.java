package com.codington.festival.Models;

import javax.persistence.*;

public class Donation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "amount", nullable = false, unique = true)
	private double amount;
	
	@OneToOne
	private int charity;

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

	public int getCharity() {
		return charity;
	}

	public void setCharity(int charity) {
		this.charity = charity;
	}

	
	
}
