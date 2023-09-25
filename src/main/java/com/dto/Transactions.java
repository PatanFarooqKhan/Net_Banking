package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transactions {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amont;
	@Id
	private String email;
	private String trancefarec_email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmont() {
		return amont;
	}
	public void setAmont(double amont) {
		this.amont = amont;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTrancefarec_email() {
		return trancefarec_email;
	}
	public void setTrancefarec_email(String trancefarec_email) {
		this.trancefarec_email = trancefarec_email;
	}
	

	
	
}
