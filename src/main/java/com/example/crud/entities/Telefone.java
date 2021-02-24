package com.example.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.crud.enums.TipoTelefone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer tipo;

	@Getter
	@Setter
	private String códigoEstado;
	@Getter
	@Setter
	private String numero;
	
	@ManyToOne
	@Getter
	@Setter
	private Cliente cliente;

	public Telefone(TipoTelefone tipo, String códigoEstado, String numero) {
		super();
		this.tipo = tipo.getCod();
		this.códigoEstado = códigoEstado;
		this.numero = numero;
	}

	public TipoTelefone getTipo() {
		return TipoTelefone.toEnum(tipo);
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo.getCod();
	}

}
