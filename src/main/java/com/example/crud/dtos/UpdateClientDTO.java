package com.example.crud.dtos;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.crud.entities.Phone;
import com.example.crud.services.validations.EmailIsNotEmpty;
import com.example.crud.services.validations.EmailIsValid;
import com.example.crud.services.validations.EmailUpdateNotRepeated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientDTO {

	
	@NotEmpty(message="O campo Nome deve ser preenchido.")
	@Size(min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres.")
	private String name;
	
	@NotEmpty(message="O campo CEP deve ser preenchido.")
	@Pattern(regexp="^(0|[1-9][0-9]*)$", message="Formato de CEP inválido, apenas números são permitidos.")
	private String zipCode;
	
	@NotEmpty(message="O campo Logradouro deve ser preenchido.")
	private String address;
	
	private String complement;
	
	@NotEmpty(message="O campo Bairro deve ser preenchido.")
	private String district;
	
	@NotEmpty(message="O campo Cidade deve ser preenchido.")
	private String city;
	
	@NotEmpty(message="O campo Estado deve ser preenchido.")
	private String state;
	
	@EmailUpdateNotRepeated
	@EmailIsValid
	@EmailIsNotEmpty
	private Set<String> emails;
	
	@NotEmpty(message="É necessário preencher pelo o menos 1 Telefone.")
	private List<Phone> phones;
	
}
