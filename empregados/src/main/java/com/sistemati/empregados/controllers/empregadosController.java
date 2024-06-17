package com.sistemati.empregados.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		System.out.println(empregado_dto);
		BeanUtils.copyProperties(empregado_dto, empregado_model);
		System.out.println(empregado_model.getAlergia());
		return ResponseEntity.status(HttpStatus.CREATED).body(empregados_repository.save(empregado_model));
	}	
	
	@GetMapping("/empregados/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value="id") Integer id){
		Optional<empregadoModel> empregado = empregados_repository.findById(id);
		if(empregado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado não encontrado.");
		}	
		return ResponseEntity.status(HttpStatus.OK).body(empregado.get());
	}
	
	@PutMapping("/empregados/{id}")
	public ResponseEntity<Object> atualizarEmpregado(@PathVariable(value="id") Integer id,
												@RequestBody @Valid empregadoDto empregado_dto){
		Optional<empregadoModel> empregado = empregados_repository.findById(id);
		if(empregado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado não encontrado.");
		}
		var empregadoModel = empregado.get();
		BeanUtils.copyProperties(empregado_dto, empregadoModel);
		return ResponseEntity.status(HttpStatus.OK).body(empregados_repository.save(empregadoModel));
	}
	
	
	@DeleteMapping("/empregados/{id}")
	public ResponseEntity<Object> deletarEmpregado(@PathVariable(value="id") Integer id){
		Optional<empregadoModel> empregado = empregados_repository.findById(id);
		if(empregado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado não encontrado.");
		} 
		empregados_repository.delete(empregado.get());
		return ResponseEntity.status(HttpStatus.OK).body("O epregado foi excluído da base de dados");
	}
	
}

