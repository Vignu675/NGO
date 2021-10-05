package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;
import com.capgemini.service.EmployeeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/employee")
@EnableSwagger2
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public NeedyPeople addNeedyPeople(@Valid @RequestBody NeedyPeople person) {
		employeeService.addNeedyPerson(person);
		return person;
	}
	
	@GetMapping("/retreive/allNeedyEmployee")
	public List<NeedyPeople> getAllNeedyPeople() {
		List<NeedyPeople> person = employeeService.findAllNeedyPeople();
		return person;
	}
	
//	@GetMapping("/retreive/NeedyEmployeeById/{id}")
//	public NeedyPeople getNeedyPeopleById(@PathVariable("id") int needyPeopleId) {
//		NeedyPeople person = employeeService.findNeedyPeopleById(needyPeopleId);
//		return person;
//	}
	
	@GetMapping("/retreive/needyPeopleByName/{name}")
	public List<NeedyPeople> getNeedyPeopleByName(@PathVariable("name") String name) {
		List<NeedyPeople> person = employeeService.findNeedyPeopleByName(name);
		return person;
	}
	
//	@DeleteMapping("/delete/{id}")
//	public void removeNeedyPeople(@PathVariable("id") int id) {
//		NeedyPeople person = employeeService.findNeedyPeopleById(id);
//		employeeService.removeNeedyPerson(person);
//	}
	
	@GetMapping("/validateEmployee/{username}/{password}")
	public Employee validateEmployee(@PathVariable("username") String username, @PathVariable("password") String password) {
		Employee employee = employeeService.login(username, password);
		return employee;
	}
	@PostMapping("/help")
	public Request helpNeedy(@RequestBody Request request) {
		return employeeService.helpNeedyPerson(request);
	}
	
	@GetMapping("/allRequests")
	public List<Request> getRequests(){
		return employeeService.getRequests();
	}
}
