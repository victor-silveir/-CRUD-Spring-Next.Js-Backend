package com.example.crud.dtos;

import java.util.List;
import java.util.Set;

import com.example.crud.entities.Telefone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostClienteDTO {

	private String nome;
	private String cpf;
	private Set<String> emails;
	private List<Telefone> telefones;
}
