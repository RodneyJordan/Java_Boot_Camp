package com.codington.festival.Models;

import javax.persistence.*;

@Entity
//@Table(name = "ticket")
public class Ticket {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TicketNum", nullable = false, unique = true)
	private String ticketNum;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
