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
@Table(name = "emplyoee_table")
public class Employee {
	@Id
	@GeneratedValue
	private int employeeId;

	@NotEmpty(message="Name")
	@NotNull( message = "Employee name must not be empty")
	private String employeeName;

	@NotNull(message = "Employee mail must not be empty")
	@Email(message = "Enter a valid email address.")
	private String email;

	@NotNull(message = "Employee phone must not be empty")
	@Size( min=10, max = 10, message = "Mobile Number should be 10 Digits.")
	private String phone;

	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@NotEmpty(message = "Employee address must not be empty")
	private Address address;

	@NotNull(message = "Employee username must not be empty")
	private String username;

	@NotNull(message = "Employee password must not be empty")
	@Size(min = 8, max = 30, message = "Minimum length of Password shall be 8 for strong security.")
	private String password;

	public Employee(String employeeName, String email, String phone, Address address, String username,
			String password) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
