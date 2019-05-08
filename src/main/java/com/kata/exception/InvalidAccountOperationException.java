package com.kata.exception;

public class InvalidAccountOperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public InvalidAccountOperationException() {
	}

	public InvalidAccountOperationException(String msg) {
		super(msg);
	}

}
