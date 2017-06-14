package com.kris.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kris.repositories.entities.UserEntity;

public interface SqlRepositoryService extends CrudRepository<UserEntity, Long>{

	public UserEntity findByEmail(String email);
	
}
