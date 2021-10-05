package com.capgemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "needy_people_table")
public class NeedyPeople {
	@Id
	@GeneratedValue
	private int needyPersonId;

	@NotEmpty(message = "Needy Person name must not be empty")
	private String needyPersonName;

	@NotEmpty(message = "Needy Person phone must not be empty")
	private String phone;

	@NotNull(message = "Needy Person phone must not be empty")
	private double familyIncome;

	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	public NeedyPeople(String needyPersonName, String phone, double familyIncome, Address address) {
		super();
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.address = address;
	}

	public NeedyPeople() {
		super();
	}

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public Address getAddress() {
		return address;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
