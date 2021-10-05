package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;

public interface EmployeeDao extends JpaRepository<NeedyPeople, Integer> {
	//	public String helpNeedyPerson(DonationDistribution distribute);
	public List<NeedyPeople> findByNeedyPersonName(String name);

	@Query("select employee from Employee employee where employee.username=:username and employee.password=:password")
	public Employee findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
