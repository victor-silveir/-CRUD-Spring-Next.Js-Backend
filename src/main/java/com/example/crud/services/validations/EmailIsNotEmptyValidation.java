package com.example.crud.services.validations;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailIsNotEmptyValidation implements ConstraintValidator<EmailIsNotEmpty, Collection<String>> {
	@Override
	public void initialize(EmailIsNotEmpty annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {

		if (emails == null || emails.isEmpty()) {
			return false;
		}
		return true;

	}
}