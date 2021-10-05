package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ad_table")
public class Admin {
	@Id
	@GeneratedValue
	private int adminId;

	@NotEmpty(message = "Username must not be empty")
	private String adminUsername;

	@NotEmpty(message = "Password must not be empty")
	@Size(min = 6, max = 30, message = "Please enter a valid password")
	private String adminPassword;

	public Admin(String adminUsername, String adminPassword) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public Admin() {
	}

	public int getAdminId() {
		return adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
