package com.sistemati.empregados.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record empregadoDto(@NotBlank String empregado,
							@NotNull String email) {

}
