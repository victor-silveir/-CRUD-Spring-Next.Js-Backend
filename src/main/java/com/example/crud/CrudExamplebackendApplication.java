package com.example.crud;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.crud.entities.Client;
import com.example.crud.entities.Phone;
import com.example.crud.enums.PhoneType;
import com.example.crud.enums.Roles;
import com.example.crud.repositories.ClientRepository;

@SpringBootApplication
public class CrudExamplebackendApplication implements CommandLineRunner{
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CrudExamplebackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Set<String> emails = new HashSet<String>();
		emails.add("vbf.silveira@gmail.com");
		emails.add("victorciclops@hotmail.com");
		
		List<Phone> phones = new ArrayList<Phone>();
		Phone phone1 = new Phone(PhoneType.CELULAR, "61", "992805336");
		phones.add(phone1);
		
		Set<Integer> roles = new HashSet<>();
		
		Client client = new Client(null, "admin", bCryptPasswordEncoder.encode("123456"), null, null, null, null, null, null, null, null, null, null, roles);
		client.addRole(Roles.ADMIN);
		
		for (Phone phone : phones) {
			phone.setClient(client);
		}
		
		clientRepository.save(client);
		
	}

}
