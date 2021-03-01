package com.example.crud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;	
	private String cpf;
	private String zipCode;
	private String address;
	private String complement;
	private String district;
	private String city;
	private String state;
	
	@ElementCollection
	@CollectionTable(name = "emails")
	private Set<String> emails = new HashSet<>();
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Phone> phones;

	public Client(Integer id, String name, String cpf, String zipCode, String address, String complement,
			String district, String city, String state) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.zipCode = zipCode;
		this.address = address;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
	}
			
	
}
