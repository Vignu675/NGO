package com.capgemini.service;

import java.util.List;

import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;


public interface NeedyPeopleService {
	public NeedyPeople registerNeedyPerson(NeedyPeople person);
	public NeedyPeople login(int id);
	public Request requestForHelp(Request request);
	public List<Request> getRequest();
}
