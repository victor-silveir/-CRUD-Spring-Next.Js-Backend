package com.example.crud.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	
	@Getter
	@Setter
	private List<String> email;
	
	
}
