package com.example.crud.enums;


public enum PhoneType {
	
	RESIDENCIAL(1, "Residencial"),
	COMERCIAL(2, "Comercial"),
	CELULAR(3, "Celular");
	
	private int cod;
	private String description;
	
	private PhoneType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return description;
	}

	public static PhoneType toEnum(Integer cod ) {
		
		if(cod == null) {
			return null;
		}
		
		for(PhoneType x : PhoneType.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}


