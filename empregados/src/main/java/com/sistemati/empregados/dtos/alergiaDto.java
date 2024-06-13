package com.sistemati.empregados.dtos;

import com.fasterxml.jackson.annotation.JsonValue;

public class alergiaDto {
	
	@JsonValue
	private String alergia;

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	
	
}
