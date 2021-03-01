package com.example.crud.services.validations;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<EmailIsValid, Collection<String>> {
	@Override
	public void initialize(EmailIsValid annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {

		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		if (emails != null && !emails.isEmpty()) {
			for (String s : emails) {
				if (!(emailRegex.matcher(s).find())) {
					return false;
				}
			}
		}
		return true;

	}
}