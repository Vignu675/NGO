package com.capgemini.exception;

public class DuplicateDonorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateDonorException() {
		super();
	}

	public DuplicateDonorException(String message) {
		super(message);
	}

}
