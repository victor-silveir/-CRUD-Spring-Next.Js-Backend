package com.example.crud.services.validations;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<EmailList, Collection<String>> {
	@Override
	public void initialize(EmailList annotation) {
	}

	@Override
	public boolean isValid(Collection<String> emails, ConstraintValidatorContext context) {

		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		for (String s : emails) {
			if (emails != null && !emails.isEmpty() && !(emailRegex.matcher(s).find())) {
				return false;
			}
		}
		return true;

	}
}