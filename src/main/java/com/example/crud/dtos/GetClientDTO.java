package com.example.crud.dtos;

import java.util.List;
import java.util.Set;

import com.example.crud.entities.Phone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetClientDTO {

	private Integer id;
	private String userName;
	private String name;
	private String cpf;
	private Set<String> emails;
	private List<Phone> phones;
	private String zipCode;
	private String address;
	private String complement;
	private String district;
	private String city;
	private String state;
	
}
