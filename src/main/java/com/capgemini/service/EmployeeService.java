package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;

public interface EmployeeService {
	public Employee login(String username, String password) throws NoSuchEmployeeException;

	public NeedyPeople addNeedyPerson(NeedyPeople person);

	public boolean removeNeedyPerson(NeedyPeople person);

	public NeedyPeople findNeedyPeopleById(int id);

	public List<NeedyPeople> findNeedyPeopleByName(String name);

	public List<NeedyPeople> findAllNeedyPeople();

	public Request helpNeedyPerson(Request request);

	public List<Request> getRequests();

}
