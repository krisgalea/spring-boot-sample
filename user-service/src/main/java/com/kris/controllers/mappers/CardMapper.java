package com.kris.controllers.mappers;

import com.kris.controllers.models.Card;
import com.kris.controllers.models.Resource;
import com.kris.services.models.CardDetails;

public class CardMapper {
	
	public static Card mapCardData(CardDetails cardData){
		Card card = new Card();
		card.setCardId(cardData.getCardId());
		card.setCardNumber(cardData.getCardNumber());
		card.setExpirationDate(cardData.getExpiration().toString());
		card.setUserResource(new Resource("/user/".concat(cardData.getUserId().toString())));
		return card;
	}

}
