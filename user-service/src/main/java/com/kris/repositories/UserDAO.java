package com.kris.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.kris.repositories.entities.UserEntity;
import com.kris.services.models.UserProfile;

/**
 * 
 * @author kris
 *
 */
@Component
public class UserDAO implements RepositoryService {

	@Autowired
	private SqlRepositoryService sqlRepoService;
	
	@Override
	@Transactional
	public void createUser(String firstName, String lastName, String email, String password) {
		//create a user entity from the details passed from the service layer 
		UserEntity user = new UserEntity();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		//save to sql 
		this.sqlRepoService.save(user);		
	}
	

	@Override
	public List<UserProfile> getUsers() {	
		List<UserEntity> users = Lists.newArrayList(this.sqlRepoService.findAll());
		return users.stream()
				.map(u -> new UserProfile(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail()))
				.collect(Collectors.toList());
	}

	@Override
	public UserProfile getUser(String email) {
		UserEntity user = this.sqlRepoService.findByEmail(email);
		if (user!=null){
			return new UserProfile(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
		}else {
			return null;
		}
	}
	
	public UserProfile getUser(Long id){
		UserEntity user = this.sqlRepoService.findOne(id);
		if(user!=null){
			return new UserProfile(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
		}else{
			return null;
		}		
	}

	@Override
	@Transactional
	public UserProfile updateUser(Long id, String firstName, String lastName, String email, String passwd) {		
		UserEntity userEntity = id != null ? this.sqlRepoService.findOne(id) : this.sqlRepoService.findByEmail(email) ;
		
		if (userEntity!=null){
		
			if (firstName!=null){
				userEntity.setFirstName(firstName);
			}
			
			if (lastName!=null){
				userEntity.setLastName(lastName);
			}
			
			if(email!=null){
				userEntity.setEmail(email);
			}
			
			if(passwd!=null){
				userEntity.setPassword(passwd);
			}
			
			//save modified user entity 
			sqlRepoService.save(userEntity);
				
			return new UserProfile(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail());
		}
		
		return null;		
		
	}
	
	public void updateUserPassword(String email, String password){
		UserEntity user = sqlRepoService.findByEmail(email);
		user.setPassword(password);		
	}

	@Override
	public void deleteUser(String email) {
		UserEntity user = sqlRepoService.findByEmail(email);
		if (user!=null){
			sqlRepoService.delete(user);
		}				
	}

	
	
	

}
