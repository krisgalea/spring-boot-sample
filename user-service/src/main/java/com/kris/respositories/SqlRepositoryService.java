package com.kris.respositories;

import org.springframework.data.repository.CrudRepository;

import com.kris.respositories.entities.UserEntity;

public interface SqlRepositoryService extends CrudRepository<UserEntity, Long>{

	public UserEntity findByEmail(String email);
	
}
