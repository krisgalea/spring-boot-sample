package com.kris.controllers.mappers;

import com.kris.controllers.models.User;
import com.kris.services.models.UserProfile;

/**
 * 
 * @author kris
 * 
 * Simple mapper class to translate between {@link UserProfile} and {@link User} 
 *
 */
public class UserProfileMapper {
	
	public static User mapUserProfileToUser(UserProfile userProfile){
		return new User(userProfile.getId(), userProfile.getFirstName(), userProfile.getLastName(), userProfile.getEmail(), null);	
	}

}
