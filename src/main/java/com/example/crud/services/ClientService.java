package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.crud.dtos.GetClientDTO;
import com.example.crud.dtos.PostClientDTO;
import com.example.crud.dtos.UpdateClientDTO;
import com.example.crud.entities.Client;
import com.example.crud.entities.Phone;
import com.example.crud.exceptions.ObjectAlreadySavedException;
import com.example.crud.exceptions.ObjectNotFoundException;
import com.example.crud.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client save(Client client) {
		client.setId(null);
		if (clientRepository.findByCpf(client.getCpf()) != null) {
			throw new ObjectAlreadySavedException("Cliente com esse CPF já cadastrado, verifique o CPF informado. CPF: " + client.getCpf());
		}
		
		addPhone(client);
		return clientRepository.save(client);
	}

	public Client findById(Integer id) {
		Optional<Client> clienteOpt = clientRepository.findById(id);
		return clienteOpt.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " + id + ", Tipo: " + Client.class.getSimpleName()));
	}
	
	public Client update(Integer id, Client client) {
		client.setId(id);
		client.setCpf(findById(client.getId()).getCpf());
		client.getPhones();
		addPhone(client);
		return clientRepository.save(client);
	}
	
	public void delete(Client client) {
		client = findById(client.getId());
		clientRepository.delete(client);
	}

	//Auxiliar methods
	public Client toCliente(PostClientDTO clientDto) {
		return modelMapper.map(clientDto, Client.class);
	}
	
	public Client toCliente(GetClientDTO clientDto) {
		return modelMapper.map(clientDto, Client.class);
	}
	
	public Client toCliente(UpdateClientDTO clientDto) {
		return modelMapper.map(clientDto, Client.class);
	}

	public GetClientDTO toGetClienteDTO(Client client) {
		return modelMapper.map(client, GetClientDTO.class);
	}

	public void addPhone(Client client) {
		for (Phone phone : client.getPhones()) {
			phone.setClient(client);
		}
	}

}
