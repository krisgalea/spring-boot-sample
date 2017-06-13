package com.kris.exceptions;

public class UserNotCreatedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8957537431635127334L;

	public UserNotCreatedException(String msg, Throwable e){
		super(msg, e);
	}
	
	public UserNotCreatedException(String msg){
		super(msg);
	}

}
