package com.kris.services;

import java.util.List;

import com.kris.exceptions.UserServiceException;
import com.kris.services.models.UserProfile;

/**
 * 
 * @author kris
 *
 */
public interface UserService {
	
	/**
	 * Creates a new instance of a user. 
	 * 
	 * @param firstName
	 * 			The user's first name
	 * 
	 * @param lastName
	 * 			The user's last name 
	 * @param email
	 * 			The email 
	 * @param password
	 * 			The password for the user in plaintext
	 * @return
	 * 			The stored instance of the user 
	 */
	public UserProfile createUser(String firstName, String lastName, String email, String password) throws UserServiceException;
	
	/**
	 * 
	 * @return
	 */
	public List<UserProfile> getUsers();
	
	/**
	 * 
	 * Updates a user
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @return
	 */
	public UserProfile updateUser(Long id, String firstName, String lastName, String email, String password);
	
	/**
	 * Retrieves a user by email address
	 * 
	 * @param email
	 * @return
	 */
	public UserProfile getUser(String email);
	
	/**
	 * Retrieves a user by id
	 * @param id
	 * @return
	 */
	public UserProfile getUser(Long id);
	
	/**
	 * Deletes the user by the given email
	 * 
	 * @param email
	 */
	public void deleteUser(String email);

}
