package com.codington.festival.Models;

import javax.persistence.*;

@Entity
@Table(name = "parking_passes")
public class ParkingPass {
	
	@Id @GeneratedValue
	private long id;
	
	@Column(name = "license_plate", nullable = false, unique = true)
	private String plate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	
	
}
