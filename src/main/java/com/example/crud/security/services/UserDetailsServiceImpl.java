package com.example.crud.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.crud.entities.User;
import com.example.crud.repositories.UserRepository;
import com.example.crud.security.UserSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserSecurity(user.getId(), user.getUserName(), user.getPassword(), user.getRoles());
	}
	

}
