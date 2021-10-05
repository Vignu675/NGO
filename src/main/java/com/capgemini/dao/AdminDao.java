package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.capgemini.model.Admin;
import com.capgemini.model.Employee;

public interface AdminDao extends JpaRepository<Employee, Integer>{
	public List<Employee> findByEmployeeName(String name);

	public Employee findByUsername(String username);



}
