package com.example.crud.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.crud.dtos.GetClienteDTO;
import com.example.crud.dtos.PostClienteDTO;
import com.example.crud.entities.Cliente;
import com.example.crud.services.ClienteService;

@Validated
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping(value = "/")
	public ResponseEntity<Cliente> postCliente(@Valid @RequestBody PostClienteDTO clienteDTO) {
		Cliente cliente = clienteService.toCliente(clienteDTO);
		cliente = clienteService.save(cliente);
		URI clienteURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(clienteURI).body(cliente);
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<GetClienteDTO>> findAllClientes() {
		List<GetClienteDTO> lista = clienteService.findAll().stream().map(clienteService::toGetClienteDTO)
				.collect(Collectors.toList());
		;
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<GetClienteDTO> findClienteById(@PathVariable Integer id) {
		GetClienteDTO clienteDTO = clienteService.toGetClienteDTO(clienteService.findById(id));
		return ResponseEntity.ok().body(clienteDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> putCliente(@PathVariable Integer id, @RequestBody GetClienteDTO clienteDTO) {
		Cliente cliente = clienteService.update(id, clienteService.toCliente(clienteDTO));
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping(value = "/") 
	public ResponseEntity<Void> deleteCliente(@RequestBody GetClienteDTO clienteDTO) {
		clienteService.delete(clienteService.toCliente(clienteDTO));
		return ResponseEntity.noContent().build();
	}

}
