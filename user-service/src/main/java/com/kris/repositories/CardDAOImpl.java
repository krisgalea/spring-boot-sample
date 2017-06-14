package com.kris.repositories;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kris.repositories.entities.CardEntity;
import com.kris.repositories.entities.UserEntity;
import com.kris.services.models.CardDetails;

@Component
public class CardDAOImpl implements CardDAO{

	@Autowired
	private CardRepositoryService cardRepo;
	
	@Autowired
	private UserRepositoryService userRepo;
	
	
	@Override
	@Transactional
	public CardDetails createCard(Long userId, String cardNumber, Date expirationDate) {
		CardEntity cardEntity = new CardEntity();		
		cardEntity.setCardNumber(cardNumber);
		cardEntity.setExpirationDate(new java.sql.Date(expirationDate.getTime()));
		
		UserEntity user = userRepo.findOne(userId);
		cardEntity.setUser(user);
		
		cardRepo.save(cardEntity);
		
		return new CardDetails(cardEntity.getId(), user.getId(), cardEntity.getCardNumber(), cardEntity.getExpirationDate());
	}

	@Override
	@Transactional
	public List<CardDetails> getCards(Long userId) {
		return userRepo.findOne(userId).getCards().stream()
				.map(c -> new CardDetails(c.getId(), c.getUser().getId(), c.getCardNumber(), c.getExpirationDate()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public CardDetails getCard(Long cardId) {
		CardEntity cardEntity = cardRepo.findOne(cardId);
		if (cardEntity!=null){
			return new CardDetails(cardEntity.getId(), cardEntity.getUser().getId(), cardEntity.getCardNumber(), cardEntity.getExpirationDate());
		}
		return null;
	}

	@Override
	public void deleteCard(Long cardId) {
		cardRepo.delete(cardId);		
		
	}
	
	

}
