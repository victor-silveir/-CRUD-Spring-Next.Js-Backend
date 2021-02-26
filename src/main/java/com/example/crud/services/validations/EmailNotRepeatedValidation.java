package com.example.crud.services.validations;

import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.entities.Client;
import com.example.crud.repositories.ClientRepository;

public class EmailNotRepeatedValidation implements ConstraintValidator<EmailNotRepeated, Collection<String>> {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void initialize(EmailNotRepeated annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {

		
			List<Client> cli = clientRepository.findByEmailsIn(emails);
			
			for (Client client : cli) {
				if (client != null) {
					return false;
				}
			}
		return true;

	}
}