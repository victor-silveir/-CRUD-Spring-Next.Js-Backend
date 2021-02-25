package com.example.crud.exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
		
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), df.format(new Date()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest req) {
		
		ValidationError erro = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validação", df.format(new Date()));
		
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			erro.addError(error.getField(), error.getDefaultMessage());
		}
			
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}