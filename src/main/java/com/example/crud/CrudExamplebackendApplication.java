package com.example.crud;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.crud.entities.User;
import com.example.crud.repositories.UserRepository;

@SpringBootApplication
public class CrudExamplebackendApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CrudExamplebackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		Set<Integer> rolesAdmin = new HashSet<>();
		rolesAdmin.add(1);
		Set<Integer> rolesCommon = new HashSet<>();
		rolesAdmin.add(2);

		

		User userAdmin = new User(null, "admin", bCryptPasswordEncoder.encode("123456"), rolesAdmin);
		User userCommon = new User(null, "comum", bCryptPasswordEncoder.encode("123456"), rolesCommon);
		
		
		userRepository.save(userAdmin);
		userRepository.save(userCommon);
		
	}

}
