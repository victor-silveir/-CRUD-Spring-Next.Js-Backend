package com.example.crud.services.validations;

import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.entities.Cliente;
import com.example.crud.repositories.ClienteRepository;

public class EmailNotRepeatedValidation implements ConstraintValidator<EmailNotRepeated, Collection<String>> {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void initialize(EmailNotRepeated annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {

		
		for (String s : emails) {
			List<Cliente> cli = clienteRepository.findByEmailsIn(emails);
			if (cli != null) {
				return false;
			}
		}
		return true;

	}
}