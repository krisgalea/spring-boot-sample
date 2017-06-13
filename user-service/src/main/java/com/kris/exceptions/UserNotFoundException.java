package com.kris.exceptions;

public class UserNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1325674971688872748L;

	public UserNotFoundException(String message){
		super(message);
	}

}
