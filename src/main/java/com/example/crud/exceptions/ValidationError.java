package com.example.crud.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;
	
	@Getter
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, String timestamp) {
		super(status, msg, timestamp);
		
	}
	
	public void addError(String fieldName, String messages) {
		errors.add(new FieldMessage(fieldName, messages));
	}

}
