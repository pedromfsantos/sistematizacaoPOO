package com.sistemati.empregados.dtos;

import com.fasterxml.jackson.annotation.JsonValue;

public class problemaSaudeDto {
	
	@JsonValue
	private String problemasaude;

	public String getProblemasaude() {
		return problemasaude;
	}

	public void setProblemasaude(String problemasaude) {
		this.problemasaude = problemasaude;
	}
}
