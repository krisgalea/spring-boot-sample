package com.kris.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kris.controllers.mappers.CardMapper;
import com.kris.controllers.models.Card;
import com.kris.exceptions.CardNotCreatedException;
import com.kris.exceptions.CardNotFoundException;
import com.kris.exceptions.DateFormatException;
import com.kris.services.CardService;
import com.kris.services.models.CardDetails;

@RestController 
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/users/{userId}/cards", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Card createCard(@PathVariable Long userId, @RequestBody Card card) throws DateFormatException, CardNotCreatedException{
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String dateInString = new java.text.SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			CardDetails cardDetails = cardService.addCardToUser(userId, card.getCardNumber(), formatter.parse(dateInString));
			if (cardDetails!=null){
				return CardMapper.mapCardData(cardDetails);
			}
			
			throw new CardNotCreatedException("Failed to create card.");
		} catch (ParseException e) {
			throw new DateFormatException("Date passed in incorrect format");
		}
	}
		
	@RequestMapping(path="/users/{userId}/cards", method=RequestMethod.GET, produces = "application/json")
	public List<Card> getCards(@PathVariable Long userId){
		return this.cardService.getCards(userId).stream()
				.map(c -> CardMapper.mapCardData(c))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(path="/users/{userId}/cards/{cardId}", method=RequestMethod.GET, produces = "application/json")
	public Card getCard(@PathVariable Long userId,@PathVariable Long cardId) throws CardNotFoundException{
		CardDetails cardData = this.cardService.getCard(userId, cardId);
		if (cardData !=null){
			return CardMapper.mapCardData(cardData);
		}
		
		throw new CardNotFoundException("Could not find card with id : ".concat(cardId.toString()));
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(path="/users/{userId}/cards/{cardId}", method=RequestMethod.DELETE)
	public void deleteCard(@PathVariable Long userId,@PathVariable Long cardId) {
		this.cardService.deleteCard(cardId);		
	}
}
