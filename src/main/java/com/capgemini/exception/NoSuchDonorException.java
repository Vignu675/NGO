package com.capgemini.exception;

public class NoSuchDonorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchDonorException() {
		super();
	}

	public NoSuchDonorException(String message) {
		super(message);
	}

}
