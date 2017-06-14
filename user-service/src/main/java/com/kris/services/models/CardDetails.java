package com.kris.services.models;

import java.sql.Date;

public class CardDetails {
	
	private Long cardId;
			
	private Long userId;
	
	private String cardNumber;
	
	private Date expiration;
	
	public CardDetails(){
		
	}

	public CardDetails(Long cardId, Long userId, String cardNumber, Date expiration) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.expiration = expiration;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
