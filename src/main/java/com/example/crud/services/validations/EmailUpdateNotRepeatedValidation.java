package com.example.crud.services.validations;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.example.crud.entities.Cliente;
import com.example.crud.repositories.ClienteRepository;

public class EmailUpdateNotRepeatedValidation implements ConstraintValidator<EmailUpdateNotRepeated, Collection<String>> {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	HttpServletRequest req;
	
	@Override
	public void initialize(EmailUpdateNotRepeated annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {
		
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			
			Integer idUri = Integer.parseInt(map.get("id"));

		
			List<Cliente> cli = clienteRepository.findByEmailsIn(emails);
			
			
			for (Cliente cliente : cli) {
				if (cliente != null && !idUri.equals(cliente.getId())) {
					return false;
				}
			}
		return true;

	}
}