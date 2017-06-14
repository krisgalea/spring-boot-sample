package com.kris.controllers.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(Include.NON_NULL)
public class Card {

	private Long cardId;
	
    @JsonSerialize(as = Resource.class)
	private Resource userResource;
	
	private String cardNumber;
	
	private String expirationDate;

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}


	public Resource getUserResource() {
		return userResource;
	}

	public void setUserResource(Resource userResource) {
		this.userResource = userResource;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
}
