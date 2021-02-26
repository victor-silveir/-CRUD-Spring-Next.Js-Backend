package com.example.crud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.crud.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
	
@Entity
@AllArgsConstructor
@Data
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String userName;
	
	@JsonIgnore
	private String password;
	
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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Roles")
	private Set<Integer> roles = new HashSet<>();
	
	public Client() {
		addRole(Roles.CLIENT);
	}
	
	public Set<Roles> getRoles() {
		return roles.stream().map(x -> Roles.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addRole(Roles role) {
		roles.add(role.getCod());
	}


		
}
