package com.sistemati.empregados.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemati.empregados.dtos.empregadoDto;
import com.sistemati.empregados.models.empregadoModel;
import com.sistemati.empregados.repositories.empregadosRepository;

import jakarta.validation.Valid;

@RestController
public class empregadosController {
	
	@Autowired
	empregadosRepository empregados_repository;
	
	@GetMapping("/empregados")
	public ResponseEntity<List<empregadoModel>> listar(){
		List<empregadoModel> empregado_list = empregados_repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(empregado_list);
	}
		
		
	@PostMapping("/empregados")
	public ResponseEntity<empregadoModel> salvar(@RequestBody @Valid empregadoDto empregado_dto){
		var empregado_model = new empregadoModel();
		BeanUtils.copyProperties(empregado_dto, empregado_model);
		return ResponseEntity.status(HttpStatus.CREATED).body(empregados_repository.save(empregado_model));
	}
}
