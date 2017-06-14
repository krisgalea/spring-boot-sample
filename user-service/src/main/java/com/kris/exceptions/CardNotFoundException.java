package com.kris.exceptions;

public class CardNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2620795183428206499L;

	public CardNotFoundException(String msg){
		super(msg);
	}

}
