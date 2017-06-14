package com.kris.services;

import java.util.Date;
import java.util.List;

import com.kris.services.models.CardDetails;

/**
 * 
 * @author kris
 * 
 * Provides an interface for interacting with cards
 *
 */
public interface CardService {
	
	/**
	 * Creates a card under the given user 
	 * @param userId
	 * 			The user id who owns the card
	 * @param cardNumber
	 * 			The encrypted card Number
	 * @param expirationDate
	 * 			The expiration date 
	 * @return
	 * 			The created card details 
	 */
	public CardDetails addCardToUser(Long userId, String cardNumber, Date expirationDate);
	
	/**
	 * 
	 * Retrieves all cards for a user
	 * 
	 * @param userId
	 * 			The user ID owning the cards
	 * @return
	 * 			A list of cards owned by the user
	 */
	public List<CardDetails> getCards(Long userId);
	
	/**
	 * 
	 * Retrieves an instance of a single card given its ID.
	 * 
	 * @param cardId
	 * 			The card ID 
	 * @return
	 * 			The card details 
	 */
	public CardDetails getCard(Long userId, Long cardId);
	
	/**
	 * 
	 * Deletes a card by ID
	 * 
	 * @param cardId
	 * 			The card id to be deleted
	 */
	public void deleteCard(Long cardId);

}
