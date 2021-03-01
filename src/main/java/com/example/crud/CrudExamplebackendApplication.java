package com.example.crud;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*")
				.allowedOrigins("hp://localhost:8080")
				.allowedHeaders("*");
			}
		};
	}

}
