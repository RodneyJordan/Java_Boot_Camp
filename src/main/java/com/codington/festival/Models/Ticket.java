package com.codington.festival.Models;

import javax.persistence.*;

@Entity
@Table(name = "Tickets")
public class Ticket {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TicketNum", nullable = false, unique = true)
	private int ticketNum;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private int user_id;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
