package com.example.crud.enums;

public enum Roles {

	ADMIN(1, "ROLE_ADMIN"),
	COMMON(2, "ROLE_COMMON");
	
	private int cod;
	private String description;
	
	private Roles(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return description;
	}

	public void setDescricao(String description) {
		this.description = description;
	}
	
	public static Roles toEnum(Integer cod ) {
		
		if(cod == null) {
			return null;
		}
		
		for(Roles x : Roles.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
