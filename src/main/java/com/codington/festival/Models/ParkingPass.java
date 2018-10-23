package com.codington.festival.Models;

import javax.persistence.*;

@Entity
//@Table(name = "parkingpass")
public class ParkingPass {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "LicensePlate", nullable = false, unique = true)
	private String plate;
	
	@OneToOne
//	@JoinColumn(name = "user_id")
    @MapsId
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
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
