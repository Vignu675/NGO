package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.RequestDao;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeRepository;

	@Autowired
	private RequestDao requestRepository;

	@Override
	public Employee login(String username, String password) throws NoSuchEmployeeException {
		Employee employee = employeeRepository.findByUsernameAndPassword(username, password);
		if (employee == null) {
			throw new NoSuchEmployeeException("No Employee Found With Matching Credentials");
		}
		return employee;
	}

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeople person) {
		return employeeRepository.save(person);

	}

	@Override
	public boolean removeNeedyPerson(NeedyPeople person) {
		employeeRepository.delete(person);
		return false;
	}

	@Override
	public NeedyPeople findNeedyPeopleById(int id) {
		NeedyPeople needyPeople = employeeRepository.findById(id).get();
		return needyPeople;
	}

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) {
		List<NeedyPeople> needyPeople = employeeRepository.findByNeedyPersonName(name);
		return needyPeople;
	}

	@Override
	public List<NeedyPeople> findAllNeedyPeople() {
		List<NeedyPeople> needyPeople = employeeRepository.findAll();
		return needyPeople;
	}

	@Override
	public Request helpNeedyPerson(Request request) {

		return requestRepository.save(request);
	}

	@Override
	public List<Request> getRequests() {

		return requestRepository.findAll();
	}

}
