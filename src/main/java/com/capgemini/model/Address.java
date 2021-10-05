package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address_table")
public class Address {
	@Id
	@GeneratedValue
	private int addressId;
	
	@NotEmpty(message = "City must not be empty")
	private String city;
	
	@NotEmpty(message="State must not be Empty")
	private String state;
	
	@NotEmpty(message = "Pin must not be empty")
	@Size (min=6, max=6, message="Pin must be Valid")
	private String pin;
	
	@NotEmpty(message = "landmark must not be empty")
	private String landmark;

	public int getAddressId() {
		return addressId;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPin() {
		return pin;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Address(String city, String state, String pin, String landmark) {
		super();
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public Address() {
		super();
	}

}
