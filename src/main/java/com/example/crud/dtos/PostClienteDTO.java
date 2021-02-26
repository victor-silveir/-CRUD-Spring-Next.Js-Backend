package com.example.crud.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.example.crud.entities.Telefone;
import com.example.crud.services.validations.EmailIsEmpty;
import com.example.crud.services.validations.EmailList;
import com.example.crud.services.validations.EmailNotRepeated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="O campo Nome deve ser preenchido.")
	@Size(min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres.")
	@Pattern(regexp ="^[a-zA-Z0-9 ]+$", message="O campo nome deve ser preenchido apenas com caracteres alfanuméricos")
	private String nome;
	
	@NotEmpty(message="O campo CPF deve ser preenchido.")
	@CPF(message="CPF inválido")
	private String cpf;
	
	@EmailNotRepeated
	@EmailList
	@EmailIsEmpty
	private Set<String> emails;
	
	@NotEmpty(message="É necessário preencher pelo o menos 1 Telefone.")
	private List<Telefone> telefones;
}
