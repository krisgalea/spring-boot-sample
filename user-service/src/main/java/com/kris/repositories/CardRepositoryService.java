package com.kris.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kris.repositories.entities.CardEntity;

public interface CardRepositoryService extends CrudRepository<CardEntity, Long>{
	
}
