package com.example.crud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/free")
public class FreeController {

	
	@GetMapping(value = "/")
	public String freeEndpoint() {
		return "API funcionando! </br> Endpoint livre de autenticação!";
	}
}
