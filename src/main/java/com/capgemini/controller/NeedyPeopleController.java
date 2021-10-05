package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;
import com.capgemini.service.NeedyPeopleService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/needyPeople")
@EnableSwagger2
public class NeedyPeopleController {

	@Autowired
	private NeedyPeopleService needyPeopoleService;

	@PostMapping("/add")
	public NeedyPeople addNeedyPeople(@Valid @RequestBody NeedyPeople person) {
		needyPeopoleService.registerNeedyPerson(person);
		return person;
	}
	
	@GetMapping("/loginNeedyPeople/{id}")
	public String validateNeedyPeople(@PathVariable("id") int id) {
		needyPeopoleService.login(id);
		return "Successfully";
	}

	@PostMapping("/help")
	public Request requestForHelp(@RequestBody Request request) {
		return needyPeopoleService.requestForHelp(request);
	}
	
	@PostMapping("/getRequests")
	public List<Request> getRequests(){
		return needyPeopoleService.getRequest();
	}
}