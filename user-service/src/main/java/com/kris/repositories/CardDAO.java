package com.kris.repositories;

import java.util.Date;
import java.util.List;

import com.kris.services.models.CardDetails;

public interface CardDAO {
	
	public CardDetails createCard(Long userId, String cardNumber, Date expirationDate);
	
	public List<CardDetails> getCards(Long userId);
	
	public CardDetails getCard(Long cardId);
	
	public void deleteCard(Long cardId);

}
