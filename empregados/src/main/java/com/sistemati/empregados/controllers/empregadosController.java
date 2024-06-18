package com.sistemati.empregados.controllers;

import java.util.ArrayList;
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
import com.sistemati.empregados.models.alergiaModel;
import com.sistemati.empregados.models.empregadoModel;
import com.sistemati.empregados.models.problemaSaudeModel;
import com.sistemati.empregados.models.telefoneModel;
import com.sistemati.empregados.repositories.alergiasRepository;
import com.sistemati.empregados.repositories.empregadosRepository;

import jakarta.validation.Valid;

@RestController
public class empregadosController {
	
	@Autowired
	empregadosRepository empregados_repository;
	
	@Autowired
	alergiasRepository alergia_repository;

	
	@GetMapping("/empregados")
	public ResponseEntity<List<empregadoModel>> listar(){
		List<empregadoModel> empregado_list = empregados_repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(empregado_list);
	}
		 
		
	@PostMapping("/empregados")
	public ResponseEntity<empregadoModel> salvar(@RequestBody @Valid empregadoDto empregado_dto){
		var empregado_model = new empregadoModel();
		
		BeanUtils.copyProperties(empregado_dto, empregado_model);
		
		//List<alergiaModel> alergias = new ArrayList<>();
		/*
		 * for (alergiaModel alergiaIn : empregado_model.getAlergia()) {
		 * 
		 * alergiaModel alergia = new alergiaModel(alergiaIn.getAlergia());
		 * 
		 * alergia.setEmpregado(empregado_model);
		 * System.out.println(alergia.getEmpregado().getId());
		 * 
		 * alergias.add(alergia); }
		 * 
		 * List<telefoneModel> telefones = new ArrayList<>(); for (telefoneModel
		 * telefoneIn : empregado_model.getTelefone()) {
		 * 
		 * telefoneModel telefone = new telefoneModel(telefoneIn.getTelefone());
		 * 
		 * telefone.setEmpregado(empregado_model);
		 * 
		 * telefones.add(telefone); }
		 * 
		 * List<problemaSaudeModel> problemasSaude = new ArrayList<>(); for
		 * (problemaSaudeModel problemaSaudeIn : empregado_model.getProblsaude()) {
		 * 
		 * problemaSaudeModel problemaSaude = new
		 * problemaSaudeModel(problemaSaudeIn.getProblsaude());
		 * 
		 * problemaSaude.setEmpregado(empregado_model);
		 * 
		 * problemasSaude.add(problemaSaude); }
		 */
		
		System.out.println(empregado_dto.alergia());
		System.out.println("Empregado Id "+ empregado_model.getId());
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

