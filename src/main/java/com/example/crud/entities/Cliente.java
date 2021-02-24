package com.example.crud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter 
	@Setter
	private String nome;	
	
	@Getter 
	@Setter
	private String cpf;
	
	@ElementCollection
	@CollectionTable(name = "emails")
	private Set<String> emails = new HashSet<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Telefone> telefones;
	
	
	
	
}
