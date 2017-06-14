package com.kris.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kris.repositories.CardDAO;
import com.kris.services.CardService;
import com.kris.services.models.CardDetails;

@Component
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDAO cardDao;
	
	@Override
	public CardDetails addCardToUser(Long userId, String cardNumber, Date expirationDate) {
		return this.cardDao.createCard(userId, cardNumber, expirationDate);
	}

	@Override
	public List<CardDetails> getCards(Long userId) {
		return this.cardDao.getCards(userId);
	}

	@Override
	public CardDetails getCard(Long userId, Long cardId) {
		CardDetails card = this.cardDao.getCard(cardId);
		if (card.getUserId().equals(userId)){
			return card;
		}
		else return null;
	}

	@Override
	public void deleteCard(Long cardId) {
		this.cardDao.deleteCard(cardId);
	}
	
	

}
