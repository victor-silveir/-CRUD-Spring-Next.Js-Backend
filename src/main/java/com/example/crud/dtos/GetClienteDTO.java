package com.example.crud.dtos;

import java.util.List;
import java.util.Set;

import com.example.crud.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClienteDTO {

	private Integer id;
	private String nome;
	private String cpf;
	private Set<String> emails;
	private List<Telefone> telefones;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
}
