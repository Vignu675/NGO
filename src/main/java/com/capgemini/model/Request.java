package com.capgemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Request {
	@Id
	@GeneratedValue
	private int RequestId;
	@OneToOne(cascade = { CascadeType.ALL })
	private NeedyPeople person;
	@NotNull(message = "Person must not be empty")
	private String RequestType;
	public int getRequestId() {
		return RequestId;
	}
	public void setRequestId(int requestId) {
		RequestId = requestId;
	}
	public NeedyPeople getPerson() {
		return person;
	}
	public void setPerson(NeedyPeople person) {
		this.person = person;
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}	
	
}
