package com.example.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.crud.entities.Client;
import com.example.crud.entities.Phone;
import com.example.crud.entities.User;
import com.example.crud.enums.PhoneType;
import com.example.crud.repositories.ClientRepository;
import com.example.crud.repositories.UserRepository;

@SpringBootApplication
public class CrudExamplebackendApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
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
		
		Phone p1 = new Phone(PhoneType.CELULAR, "61", "981818181");
		Phone p2 = new Phone(PhoneType.RESIDENCIAL, "61", "34445555");
		Phone p3 = new Phone(PhoneType.COMERCIAL, "61", "32323333");
		Phone p4 = new Phone(PhoneType.CELULAR, "61", "989898585");
		Phone p5 = new Phone(PhoneType.CELULAR, "61", "989898585");
		Phone p6 = new Phone(PhoneType.COMERCIAL, "61", "998822520");
		
		List<Phone> p1s = new ArrayList<Phone>();
		List<Phone> p2s = new ArrayList<Phone>();
		List<Phone> p3s = new ArrayList<Phone>();
		List<Phone> p4s = new ArrayList<Phone>();
		List<Phone> p5s = new ArrayList<Phone>();
		List<Phone> p6s = new ArrayList<Phone>();
		p1s.add(p1);
		p2s.add(p2);
		p3s.add(p3);
		p4s.add(p4);
		p5s.add(p5);
		p6s.add(p6);

		
		
		Client cli1 = new Client(null, "João", "43403196003", "73737737", "rua 1", "complemento 1", "bairro 1", "Brasilia", "DF");
		Client cli2 = new Client(null, "Maria", "61654755079", "74747747", "rua 2", "complemento 2", "bairro 2", "Brasilia", "DF");
		Client cli3 = new Client(null, "Roberto", "00999109006", "75757757", "rua 3", "complemento 3", "bairro 3", "Brasilia", "DF");
		Client cli4 = new Client(null, "Clara", "52435104081", "76776766", "rua 4", "complemento 4", "bairro 4", "Brasilia", "DF");
		Client cli5 = new Client(null, "Raimundo", "48578002091", "777777777", "rua 5", "complemento 5", "bairro 5", "Brasilia", "DF");
		Client cli6 = new Client(null, "Érica", "89686446087", "787788787", "rua 6", "complemento 6", "bairro 6", "Brasilia", "DF");
		
		cli1.setPhones(p1s);
		cli2.setPhones(p2s);
		cli3.setPhones(p3s);
		cli4.setPhones(p4s);
		cli5.setPhones(p5s);
		cli6.setPhones(p6s);
				
		cli1.getEmails().addAll(Arrays.asList("joao@gmail.com"));
		cli2.getEmails().addAll(Arrays.asList("maria@gmail.com"));
		cli3.getEmails().addAll(Arrays.asList("roberto@gmail.com", "roberto@hotmail.com"));
		cli4.getEmails().addAll(Arrays.asList("clara@gmail.com"));
		cli5.getEmails().addAll(Arrays.asList("raimundo@gmail.com", "raimundo@hotmail.com"));
		cli6.getEmails().addAll(Arrays.asList("erica@gmail.com", "erica@hotmail.com"));
		

		List<Client> clients = new ArrayList<Client>();
		
		p1.setClient(cli1);
		p2.setClient(cli2);
		p3.setClient(cli3);
		p4.setClient(cli4);
		p5.setClient(cli5);
		p6.setClient(cli6);
		
		clients.add(cli1);
		clients.add(cli2);
		clients.add(cli3);
		clients.add(cli4);
		clients.add(cli5);
		clients.add(cli6);
		
		userRepository.save(userAdmin);
		userRepository.save(userCommon);
		clientRepository.saveAll(clients);
		
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
