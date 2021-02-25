package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dtos.GetClienteDTO;
import com.example.crud.dtos.PostClienteDTO;
import com.example.crud.entities.Cliente;
import com.example.crud.entities.Telefone;
import com.example.crud.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ModelMapper modelMapper;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente save(Cliente cliente) {
		addTelefone(cliente);
		return clienteRepository.save(cliente);
	}

	public Cliente findById(Integer id) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		return clienteOpt.get();

	}
	
	public Cliente update(Integer id, Cliente cliente) {
		cliente.setId(id);
		cliente.getTelefones();
		addTelefone(cliente);
		return clienteRepository.save(cliente);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public Cliente toCliente(PostClienteDTO clienteDTO) {
		return modelMapper.map(clienteDTO, Cliente.class);
	}
	
	public Cliente toCliente(GetClienteDTO clienteDTO) {
		return modelMapper.map(clienteDTO, Cliente.class);
	}

	public GetClienteDTO toGetClienteDTO(Cliente cliente) {
		return modelMapper.map(cliente, GetClienteDTO.class);
	}

	public void addTelefone(Cliente cliente) {
		for (Telefone telefone : cliente.getTelefones()) {
			telefone.setCliente(cliente);
		}
	}

}
