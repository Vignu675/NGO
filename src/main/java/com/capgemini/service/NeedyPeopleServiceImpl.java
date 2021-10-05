package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.dao.RequestDao;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;

@Service
@Transactional
public class NeedyPeopleServiceImpl implements NeedyPeopleService {

	@Autowired
	private NeedyPeopleDao needyPeopleRepository;	
		
	@Autowired
	private RequestDao requestRepository;
	
	@Override
	public NeedyPeople registerNeedyPerson(NeedyPeople person) {
		needyPeopleRepository.save(person);
		return person;
	}

	@Override
	public NeedyPeople login(int id) {
		Optional<NeedyPeople> needyPeople = needyPeopleRepository.findById(id);
		return needyPeople.get();
	}

	@Override
	public Request requestForHelp(Request request) {
		return requestRepository.save(request);
	}

	@Override
	public List<Request> getRequest() {
		return requestRepository.findAll();
	}

}
