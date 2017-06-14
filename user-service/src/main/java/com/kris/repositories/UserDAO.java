package com.kris.repositories;

import java.util.List;

import com.kris.services.models.UserProfile;

/**
 * 
 * @author kris
 *
 */
public interface UserDAO {

	/**
	 * Creates a new user using basic fields
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public void createUser(String firstName, String lastName, String email, String password);

	/**
	 * Retrieves a full list of users
	 * 
	 * @return A full list of users without passwords and DB ids
	 */
	public List<UserProfile> getUsers();

	/**
	 * retrieves a unique user by email
	 * 
	 * @param email
	 *            the email address of the target user
	 * @return The {@link UserProfile} associated with this user
	 */
	public UserProfile getUser(String email);

	/**
	 * Updates a user by the given email for the non null fields
	 * 
	 * @param id
	 * 		the id of the user to modify 	 
	 * @param firstName
	 * 			the first name of the user to update
	 * @param lastName
	 * 			The last name of the user to update
	 * @param email
	 * 			The email of the user to update
	 * @param passwd
	 * 			The password of the user to update
	 * @return
	 * 		A {@link UserProfile} for the updated user
	 */
	public UserProfile updateUser(Long id, String firstName, String lastName, String email, String passwd);

	/**
	 * Deletes a user by email
	 * 
	 * @param email
	 *            Unique email of the user to delete
	 */
	public void deleteUser(String email);

}
