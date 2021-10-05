package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.capgemini.model.Admin;
import com.capgemini.model.Donation;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Donor;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Controller to manage Employee
 * 
 * @author ADMIN
 *
 */
@RestController
@RequestMapping("/admin")
@EnableSwagger2
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * Method to add Employee
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		employee = adminService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/**
	 * Method to retrieve Employee Details
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/retreive/allEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = adminService.findAllEmployee();
		return employees;
	}

	/**
	 * Method to retrieve Employee Details using EmployeeId
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/retreive/employeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") int employeeId) {
		Employee employee = adminService.findEmployeeById(employeeId);
		return employee;
	}

	/**
	 * Method to retrieve Employee Details using EmployeeName
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/retreive/employeeByName/{name}")
	public List<Employee> getEmployeeByName(@PathVariable("name") String name) {
		List<Employee> employees = adminService.findEmployeeByName(name);
		return employees;
	}

	/**
	 * Method to Update Employee Details using EmployeeId
	 * 
	 * @param employee
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@Valid @PathVariable("id") int employeeId, @RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		adminService.modifyEmployee(employee);
		return employee;
	}

	/**
	 * Method to remove Employee Details using EmployeeId
	 * 
	 * @param employee
	 * @return
	 */
	@DeleteMapping("remove/{id}")
	public String deleteEmployee(@PathVariable("id") int employeeId) {
		adminService.removeEmployee(employeeId);
		return "Employee with Id " + employeeId + " is deleted";
	}

	/**
	 * Method to add Donation Details
	 * 
	 * @param employee
	 * @return
	 */

	@PostMapping("/approveDonation")
	public DonationDistribution approveDonation(@Valid @RequestBody DonationDistribution donationDistribution) {
		adminService.approveDonation(donationDistribution);
		return donationDistribution;
	}

	/**
	 * Method to get Donor Details using DonorId
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/getDonor/{donorId}")
	public Optional<Donor> getDonor(@PathVariable("donorId") int donorId) {
		return adminService.getDonorById(donorId);
	}

	/**
	 * Method to get All Donar Details
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/getDonor")
	public List<Donor> getAllDonor() {
		return adminService.getDonors();
	}

	/**
	 * Method to get Donation Details using DonationId
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/getDonation/{donationId}")
	public Optional<Donation> getAllDonation(@PathVariable("donationId") int donationId) {
		return adminService.getDonationById(donationId);
	}

	/**
	 * Method to get All Donation Details
	 * 
	 * @param employee
	 * @return
	 */
	@GetMapping("/getDonation")
	public List<Donation> getDonation() {
		return adminService.getDonations();
	}

}
