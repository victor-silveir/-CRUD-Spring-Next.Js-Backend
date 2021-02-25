package com.example.crud.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.crud.enums.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer tipo;

	@Getter
	@Setter
	private String codigoEstado;
	
	@Getter
	@Setter
	private String numero;
	
	@ManyToOne
	@Setter
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Telefone(TipoTelefone tipo, String codigoEstado, String numero) {
		super();
		this.tipo = tipo.getCod();
		this.codigoEstado = codigoEstado;
		this.numero = numero;
	}
	
	@JsonIgnore
	public Cliente getCliente() {
		return cliente;
	}

	public TipoTelefone getTipo() {
		return TipoTelefone.toEnum(tipo);
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo.getCod();
	}

}
