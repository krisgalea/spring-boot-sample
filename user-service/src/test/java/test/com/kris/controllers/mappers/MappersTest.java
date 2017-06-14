package test.com.kris.controllers.mappers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kris.controllers.mappers.CardMapper;
import com.kris.controllers.mappers.UserProfileMapper;
import com.kris.controllers.models.Card;
import com.kris.controllers.models.User;
import com.kris.services.models.CardDetails;
import com.kris.services.models.UserProfile;

import test.com.kris.controllers.configuration.TestConfiguration;
import uk.co.jemos.podam.api.PodamFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class MappersTest {
	
	@Autowired
	private PodamFactory podam;
	
	@Test
	public void testMapUserProfile(){
		UserProfile userProfile = podam.manufacturePojoWithFullData(UserProfile.class);
		User user = UserProfileMapper.mapUserProfileToUser(userProfile);
		Assert.assertTrue(user.getEmail().equals(userProfile.getEmail()));
		Assert.assertTrue(user.getFirstName().equals(userProfile.getFirstName()));
		Assert.assertTrue(user.getLastName().equals(userProfile.getLastName()));
	}
	
	@Test
	public void testMapCardDetails(){
		CardDetails cardDetails = podam.manufacturePojo(CardDetails.class);
		Card card = CardMapper.mapCardData(cardDetails);
		Assert.assertTrue(card.getCardNumber().equals(cardDetails.getCardNumber()));		
	}
	

}
