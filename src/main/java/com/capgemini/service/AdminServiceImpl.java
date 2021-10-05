package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.AdminDao;
import com.capgemini.dao.DonationDao;
import com.capgemini.dao.DonationDistributionDao;
import com.capgemini.dao.DonorDao;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.exception.NoSuchEmployeeException;
//import com.capgemini.model.Admin;
import com.capgemini.model.Donation;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Donor;
import com.capgemini.model.Employee;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminRepository;

	@Autowired
	private DonationDistributionDao donationDistributionDao;

	@Autowired
	private DonorDao donorRepository;

	@Autowired
	private DonationDao donationRepository;


	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException {
		Employee empObj = null;
		Optional<Employee> emp = adminRepository.findById(employee.getEmployeeId());

		if (!emp.isEmpty()) {
			throw new DuplicateEmployeeException("Employee Already Exists with username");
		} else {
			empObj = adminRepository.save(employee);
		}

		return empObj;
	}

	@Override
	public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException {
		Optional<Employee> checkIfExists = adminRepository.findById(employee.getEmployeeId());
		if (checkIfExists.isEmpty()) {
			throw new NoSuchEmployeeException("No Employee With employoee id " + employee.getEmployeeId() + " Exists");
		}
		adminRepository.save(employee);
		return employee;
	}

	@Override
	public void removeEmployee(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> checkIfExists = adminRepository.findById(employeeId);
		if (checkIfExists.isEmpty()) {
			throw new NoSuchEmployeeException("No Employee With employoee id " + employeeId + " Exists");
		}
		adminRepository.deleteById(employeeId);
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		Optional<Employee> employee = adminRepository.findById(employeeId);
		if (employee.isEmpty()) {
			throw new NoSuchEmployeeException("No Employee With employoee id " + employeeId + " Exists");
		}
		return employee.get();
	}

	@Override
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {
		List<Employee> employees = adminRepository.findByEmployeeName(name);
		if (employees.size() == 0) {
			throw new NoSuchEmployeeException("No Employee Found with " + name + " as their name");
		}
		return employees;
	}

	@Override
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {
		List<Employee> employees = adminRepository.findAll();
		if (employees.size() == 0) {
			throw new NoSuchEmployeeException("No Employee Found ");
		}
		return employees;
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		donationDistributionDao.save(distribution);
		return false;
	}

	@Override
	public List<Donor> getDonors() {
		return donorRepository.findAll();
	}

	@Override
	public Optional<Donor> getDonorById(int donorId) {
		Optional<Donor> donor = donorRepository.findById(donorId);
		if (donor.isEmpty()) {
			throw new NoSuchDonorException("No Donor Exists With Matching Id " + donorId);
		} else
			donorRepository.findById(donorId);

		return donor;
	}

	@Override
	public Optional<Donation> getDonationById(int donationId) {
		Optional<Donation> donation = donationRepository.findById(donationId);
		return donation;
	}

	@Override
	public List<Donation> getDonations() {
		return donationRepository.findAll();
	}


}
