package com.sistemati.empregados.dtos;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sistemati.empregados.models.alergiaModel;
import com.sistemati.empregados.models.problemaSaudeModel;
import com.sistemati.empregados.models.telefoneModel;

import deserializers.StringListTrimDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record empregadoDto( @NotBlank String empregado,
		 					@NotNull String email,
		 					@JsonDeserialize(using = StringListTrimDeserializer.class) List<telefoneModel> telefone,
		 					@JsonDeserialize(using = StringListTrimDeserializer.class) List<alergiaModel> alergia,
		 					@JsonDeserialize(using = StringListTrimDeserializer.class) List<problemaSaudeModel> problemasaude) {
	
	
	
	

}
