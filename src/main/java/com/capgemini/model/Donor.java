package com.capgemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "donor_table")

public class Donor {
	@Id
	@GeneratedValue
	private int donorId;

	@NotNull(message = "Donor name must not be empty")
	private String donorName;

	@NotNull(message = "Donor email must not be empty")
	@Email(message = "Enter a valid email address.")
	private String donorEmail;
	
	@Size(min=10, max=10, message="Phone number must be Valid")
	@NotNull(message="Number must not be emoty")
	private String donorPhone;

	@NotEmpty(message = "Username must not be empty")
	private String donorUsername;

	@NotNull(message = "Password must not be empty")
	@Size(min = 6, max = 30, message = "Please enter a valid password")
	private String donorPassword;

	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	public Donor(String donorName, String donorEmail, String donorPhone, String donorUsername, String donorPassword,
			Address address) {
		super();
		this.donorName = donorName;
		this.donorEmail = donorEmail;
		this.donorPhone = donorPhone;
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
		this.address = address;
	}

	public Donor() {
		super();
	}

	public int getDonorId() {
		return donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public String getDonorPhone() {
		return donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
