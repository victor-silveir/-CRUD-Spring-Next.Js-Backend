package com.example.crud.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.crud.enums.PhoneType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Phone implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull(message="O campo Tipo deve ser informado.")
	private Integer type;

	@Getter
	@Setter
	@NotEmpty(message="O campo Código deve ser informado.")
	private String stateCode;
	
	@Getter
	@Setter
	@NotEmpty(message="O campo Telefone deve ser informado.")
	@Pattern(regexp="^(0|[1-9][0-9]*)$", message="Formato de Telefone inválido, apenas números são permitidos.")
	private String number;
	
	@ManyToOne
	@Setter
	@JoinColumn(name = "client_id")
	private Client client;

	public Phone(PhoneType type, String stateCode, String number) {
		super();
		this.type = type.getCod();
		this.stateCode = stateCode;
		this.number = number;
	}
	
	@JsonIgnore
	public Client getCliente() {
		return client;
	}

	public PhoneType getType() {
		return PhoneType.toEnum(type);
	}

	public void setType(PhoneType type) {
		this.type = type.getCod();
	}

}
