package com.exception;

public class SomethingWentWrong extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SomethingWentWrong() {
		super("Something Went Wrong!!!");
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
