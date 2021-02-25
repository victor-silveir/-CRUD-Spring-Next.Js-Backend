package com.example.crud.services.validations;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailIsEmptyValidation implements ConstraintValidator<EmailIsEmpty, Collection<String>> {
	@Override
	public void initialize(EmailIsEmpty annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {

		if (emails == null || emails.isEmpty()) {
			return false;
		}
		return true;

	}
}