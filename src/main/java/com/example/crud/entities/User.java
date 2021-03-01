package com.example.crud.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.crud.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String userName;

	@JsonIgnore
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Roles")
	private Set<Integer> roles = new HashSet<>();
	
	public User() {
		addRole(Roles.COMMON);
	}
	
	public Set<Roles> getRoles() {
		return roles.stream().map(x -> Roles.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addRole(Roles role) {
		roles.add(role.getCod());
	}
}
