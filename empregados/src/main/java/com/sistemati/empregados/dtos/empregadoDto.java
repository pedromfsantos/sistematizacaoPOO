package com.sistemati.empregados.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import deserializers.StringListTrimDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record empregadoDto( @NotBlank String empregado,
		 					@NotNull String email,
		 					@JsonDeserialize(using = StringListTrimDeserializer.class) List<String> telefone,
		 					@JsonDeserialize(using = StringListTrimDeserializer.class) List<String> alergia,
		 					@JsonDeserialize(using = StringListTrimDeserializer.class) List<String> problemasaude) {
	
	
	
	

}
