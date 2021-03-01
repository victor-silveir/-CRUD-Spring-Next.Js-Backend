package com.example.crud.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	public List<Client> findByEmailsIn(Collection<String> emails);
	
	public Client findByCpf(String cpf);
	
}
