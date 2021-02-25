package com.example.crud.exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
