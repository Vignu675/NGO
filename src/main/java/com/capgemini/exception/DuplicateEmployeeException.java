package com.capgemini.exception;

public class DuplicateEmployeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEmployeeException() {
		super();
	}

	public DuplicateEmployeeException(String message) {
		super(message);
	}

}
