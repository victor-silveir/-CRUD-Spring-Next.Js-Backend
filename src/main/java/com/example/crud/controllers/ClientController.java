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

import com.example.crud.dtos.GetClientDTO;
import com.example.crud.dtos.PostClientDTO;
import com.example.crud.dtos.UpdateClientDTO;
import com.example.crud.entities.Client;
import com.example.crud.services.ClientService;

@Validated
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping(value = "/")
	public ResponseEntity<Client> postCliente(@Valid @RequestBody PostClientDTO clientDto) {
		Client client = clientService.toCliente(clientDto);
		client = clientService.save(client);
		URI clienteURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId())
				.toUri();
		return ResponseEntity.created(clienteURI).body(client);
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<GetClientDTO>> findAllClientes() {
		List<GetClientDTO> lista = clientService.findAll().stream().map(clientService::toGetClienteDTO)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<GetClientDTO> findClienteById(@PathVariable Integer id) {
		GetClientDTO clientDto = clientService.toGetClienteDTO(clientService.findById(id));
		return ResponseEntity.ok().body(clientDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> putCliente(@PathVariable Integer id, @Valid @RequestBody UpdateClientDTO clientDto) {
		Client client = clientService.update(id, clientService.toCliente(clientDto));
		return ResponseEntity.ok().body(client);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Integer id, @RequestBody GetClientDTO clientDto) {
		clientService.delete(clientService.toCliente(clientDto), id);
		return ResponseEntity.noContent().build();
	}

}
