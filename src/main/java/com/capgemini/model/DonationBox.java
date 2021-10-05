package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="donation_box_table")
public class DonationBox {

	@NotEmpty(message = "NGO Name must not be empty")
	private String ngoName;
	@Id
	private String registrationNumber;
	
	@Size (min=8, max= 12, message="Account Number must be Valid")
	@NotEmpty (message = "The Account must not be Empty")
	private String accountNumber;
	
	@NotEmpty(message="The total Collection Must be Not empty ")
	private double totalCollection;

	public DonationBox(String ngoName, String registrationNumber, String accountNumber, double totalCollection) {
		super();
		this.ngoName = ngoName;
		this.registrationNumber = registrationNumber;
		this.accountNumber = accountNumber;
		this.totalCollection = totalCollection;
	}

	public DonationBox() {
		super();
	}

	public String getNgoName() {
		return ngoName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getTotalCollection() {
		return totalCollection;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}

}
