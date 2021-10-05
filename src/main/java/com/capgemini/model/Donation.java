package com.capgemini.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "donation_table")
public class Donation {
	@Id
	@GeneratedValue
	private int donationId;

	@OneToOne(cascade = { CascadeType.ALL })
	@NotEmpty(message = "Donor must not be empty")
	private Donor donor;

	@OneToOne(cascade = { CascadeType.ALL })
	@NotEmpty(message = "Donation Item must not be empty")
	private DonationItem item;

	@NotEmpty(message = "Donation Amount must not be empty")
	private double donationAmount;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message = "Donation date must be either Present or Future")
	@NotEmpty(message = "Donation date must not be empty")
	private Date donationDate;

	public Donation(Donor donor, DonationItem item, double donationAmount, Date donationDate) {
		super();
		this.donor = donor;
		this.item = item;
		this.donationAmount = donationAmount;
		this.donationDate = donationDate;
	}

	public Donation() {
		super();
	}

	public int getDonationId() {
		return donationId;
	}

	public Donor getDonor() {
		return donor;
	}

	public DonationItem getItem() {
		return item;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

}
