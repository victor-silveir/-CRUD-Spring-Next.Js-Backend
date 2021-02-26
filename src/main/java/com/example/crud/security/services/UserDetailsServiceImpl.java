package com.example.crud.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.crud.entities.Client;
import com.example.crud.repositories.ClientRepository;
import com.example.crud.security.UserSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client = clientRepository.findByUserName(username);
		
		if (client == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserSecurity(client.getId(), client.getUserName(), client.getPassword(), client.getRoles());
	}
	

}
