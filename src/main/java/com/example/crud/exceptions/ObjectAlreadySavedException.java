package com.example.crud.exceptions;

public class ObjectAlreadySavedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectAlreadySavedException(String msg) {
		super(msg);
	}
	
	public ObjectAlreadySavedException(String msg, Throwable cause) {
		super(msg, cause);
	}


}
