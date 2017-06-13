package com.kris.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.kris.exceptions.UserServiceException;
import com.kris.respositories.UserDAO;
import com.kris.services.UserService;
import com.kris.services.models.UserProfile;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	public PasswordEncoder encoder;
	
	@Override
	public UserProfile createUser(String firstName, String lastName, String email, String password) throws UserServiceException {		
		if(this.userDAO.getUser(email)!=null){
			throw new UserServiceException("Email already exists!");
		}
		
		//encode pass 
		password = encoder.encode(password);
		userDAO.createUser(firstName, lastName, email, password);
		//return the created object 
		return userDAO.getUser(email);
	}

	@Override
	public List<UserProfile> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public UserProfile getUser(String email) {
		return userDAO.getUser(email);
	}

	@Override
	public void deleteUser(String email) {
		this.userDAO.deleteUser(email);
	}

	@Override
	public UserProfile updateUser(Long id, String firstName, String lastName, String email, String password) {		
		//hash new pass 
		if (password!=null){
			password = encoder.encode(password);
		}
		return this.userDAO.updateUser(id, firstName, lastName, email, password);				
	}

	@Override
	public UserProfile getUser(Long id) {
		return userDAO.getUser(id);
	}

	
	

}
