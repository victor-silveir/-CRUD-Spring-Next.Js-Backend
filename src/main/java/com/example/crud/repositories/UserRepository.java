package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
			
	public User findByUserName(String userName);
	
}