package com.exception;

public class DataNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
