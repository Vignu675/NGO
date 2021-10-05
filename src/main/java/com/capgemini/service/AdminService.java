package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.exception.NoSuchEmployeeException;
//import com.capgemini.model.Admin;
import com.capgemini.model.Donation;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Donor;
import com.capgemini.model.Employee;

public interface AdminService {
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException;

	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException;

	public void removeEmployee(int employeeId) throws NoSuchEmployeeException;

	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException;

	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException;

	public List<Employee> findAllEmployee() throws NoSuchEmployeeException;

	public boolean approveDonation(DonationDistribution distribution);

	public Optional<Donor> getDonorById(int donorId) throws NoSuchDonorException;

	public List<Donor> getDonors();

	public Optional<Donation> getDonationById(int donationId);

	public List<Donation> getDonations();
	
}
