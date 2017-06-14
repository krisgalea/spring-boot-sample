package com.kris.controllers;

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

import com.kris.controllers.mappers.UserProfileMapper;
import com.kris.controllers.models.User;
import com.kris.exceptions.UserNotCreatedException;
import com.kris.exceptions.UserNotFoundException;
import com.kris.exceptions.UserServiceException;
import com.kris.services.UserService;
import com.kris.services.models.UserProfile;

/**
 * 
 * @author kris
 * 
 * Controller used for user actions
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/users", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) throws UserNotCreatedException{
		try{
			UserProfile userProfile = userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
			if (userProfile==null){ 
				throw new UserNotCreatedException("Failed to create a new user");
			}
			
			return UserProfileMapper.mapUserProfileToUser(userProfile);
		}catch (UserServiceException usx){
			throw new UserNotCreatedException("Failed to create a new user", usx);
		}
		
	}
	
	@RequestMapping(path="/users", method = RequestMethod.GET)
	public List<User> getUsers(){
		return this.userService.getUsers().stream()
				.map(u -> UserProfileMapper.mapUserProfileToUser(u))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) throws UserNotFoundException{
		UserProfile userProfile = this.userService.getUser(id);
		if (userProfile == null){
			throw new UserNotFoundException("Could not find user with id: ".concat(id.toString()).concat("."));
		}
		return UserProfileMapper.mapUserProfileToUser(userProfile);
	}
	
	
	@RequestMapping(path="/users/{id}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable Long id, @RequestBody User user) throws UserNotFoundException {
		UserProfile userProfile = this.userService.updateUser(id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
		if (userProfile==null){
			throw new UserNotFoundException("Could not find user with id : ".concat(id.toString()));
		}
		return UserProfileMapper.mapUserProfileToUser(userProfile);
	}
	
	@RequestMapping(path="/users/{id}", method=RequestMethod.PATCH)
	public User updateUserPassword(@PathVariable Long id, @RequestBody String password) throws UserNotFoundException {
		UserProfile userProfile = this.userService.updateUser(id, null, null, null, password);
		if (userProfile==null){
			throw new UserNotFoundException("Could not find user with id : ".concat(id.toString()));
		}
		return UserProfileMapper.mapUserProfileToUser(userProfile);
	}
	

}
