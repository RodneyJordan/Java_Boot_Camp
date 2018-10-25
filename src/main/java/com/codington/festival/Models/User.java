package com.codington.festival.Models;

import java.util.ArrayList;
import java.util.List;

import com.codington.festival.Models.Ticket;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
    @Id
    @GeneratedValue
    private Long id;
	
	@Column(nullable = false)
	private String first_name;
	
	@Column(nullable = false)
	private String last_name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private Boolean volunteer;
	
	
	public Boolean getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Boolean volunteer) {
		this.volunteer = volunteer;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List <Ticket> tickets;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List <ParkingPass> parkingPasses;
	
	
	public User() {
		
	}
	
	 public User(User copy) {
	        id = copy.id;
	        email = copy.email;
	        password = copy.password;
	        first_name = copy.first_name;
	        last_name = copy.last_name;
	        volunteer = copy.volunteer;
	    }

	public User(String first_name,String last_name,String email, String password, Boolean volunteer) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.volunteer = volunteer;
	}
	
	public User(Long id,String first_name,String last_name,String email, String password, Boolean volunteer) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.volunteer = volunteer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
