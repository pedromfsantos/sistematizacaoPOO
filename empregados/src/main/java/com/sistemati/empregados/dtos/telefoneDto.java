package com.sistemati.empregados.dtos;

import com.fasterxml.jackson.annotation.JsonValue;

public record telefoneDto (@JsonValue String telefone){

	/*@JsonValue
	private String telefone;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}*/
	
}
