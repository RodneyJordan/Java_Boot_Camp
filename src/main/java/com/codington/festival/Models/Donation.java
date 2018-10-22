package com.codington.festival.Models;

import javax.persistence.*;

@Entity
//@Table(name = "donation")
public class Donation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "amount", nullable = false, unique = true)
	private double amount;
	
	@OneToOne
    @MapsId
	private Charity charity;

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

	public Charity getCharity() {
		return charity;
	}

	public void setCharity(Charity charity) {
		this.charity = charity;
	}

	
	
}
