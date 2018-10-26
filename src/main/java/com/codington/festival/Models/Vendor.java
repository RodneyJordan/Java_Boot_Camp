package com.codington.festival.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "vendor")
public class Vendor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;
	
	@Column(name = "URL", nullable = false, unique = true)
	private String url;
	
	private boolean approved;
		

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Vendor() {
		super();
	}

	public Vendor(String name, String email, String phone, String url) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.url = url;
	}

	public Vendor(String name, String email, String phone, String url, boolean approved) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.url = url;
		this.approved = approved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
