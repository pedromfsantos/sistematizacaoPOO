package com.sistemati.empregados.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
import com.sistemati.empregados.repositories.problSaudeRepository;
import com.sistemati.empregados.repositories.telefonesRepository;

import jakarta.validation.Valid;

@RestController
public class empregadosController {

	@Autowired
	empregadosRepository empregados_repository;

	@Autowired
	alergiasRepository alergia_repository;
	
	@Autowired
	telefonesRepository telefone_repository;
	
	@Autowired
	problSaudeRepository problsaude_repository;
	

	@GetMapping("/empregados")
	public ResponseEntity<List<empregadoModel>> listar() {
		List<empregadoModel> empregado_list = empregados_repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(empregado_list);
	}

	@PostMapping("/empregados")
	public ResponseEntity<empregadoModel> salvar(@RequestBody @Valid empregadoModel empregado_dto) {

		var empregado_model = new empregadoModel(empregado_dto.getEmpregado(), empregado_dto.getEmail());

		List<alergiaModel> alergias = new ArrayList<>();

		for (alergiaModel alergiaIn : empregado_dto.getAlergia()) {

			alergiaModel alergia = new alergiaModel(alergiaIn.getAlergia());

			alergia.setEmpregado(empregado_model);

			alergias.add(alergia);

		}

		List<telefoneModel> telefones = new ArrayList<>();

		for (telefoneModel telefoneIn : empregado_dto.getTelefone()) {

			telefoneModel telefone = new telefoneModel(telefoneIn.getTelefone());

			telefone.setEmpregado(empregado_model);

			telefones.add(telefone);
		}

		List<problemaSaudeModel> problemasSaude = new ArrayList<>();
		for (problemaSaudeModel problemaSaudeIn : empregado_dto.getProblsaude()) {

			problemaSaudeModel problemaSaude = new problemaSaudeModel(problemaSaudeIn.getProblsaude());

			problemaSaude.setEmpregado(empregado_model);

			problemasSaude.add(problemaSaude);
		}

		empregado_model.setAlergia(alergias);
		empregado_model.setProblsaude(problemasSaude);
		empregado_model.setTelefone(telefones);

		return ResponseEntity.status(HttpStatus.CREATED).body(empregados_repository.save(empregado_model));
	}

	@GetMapping("/empregados/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable(value = "id") Integer id) {
		Optional<empregadoModel> empregado = empregados_repository.findById(id);
		if (empregado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(empregado.get());
	}

	@PutMapping("/empregados/{id}")
	public ResponseEntity<Object> atualizarEmpregado(@PathVariable(value = "id") Integer id,
			@RequestBody @Valid empregadoDto empregado_dto) {

		Optional<empregadoModel> empregado = empregados_repository.findById(id);

		if (empregado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado não encontrado.");
		}

		var empregadoModel = empregado.get();

		alergiaModel alergiaExample = new alergiaModel();
		alergiaExample.setEmpregado(empregadoModel);

		Example<alergiaModel> example = Example.of(alergiaExample);

		List<alergiaModel> alergia = alergia_repository.findAll(example);

			
		for (int i = 0; i < empregado_dto.alergia().size(); i++) {
			
			var alergiaModel = alergia.get(i);
			alergiaModel.setAlergia(empregado_dto.alergia().get(i).getAlergia());
			// System.out.println(empregado_dto.alergia().get(i).getAlergia());

		}
		
		
		telefoneModel telefoneExample = new telefoneModel();
		telefoneExample.setEmpregado(empregadoModel);

		Example<telefoneModel> exampletel = Example.of(telefoneExample);

		List<telefoneModel> telefone = telefone_repository.findAll(exampletel);
		
		for (int i = 0; i < telefone.size(); i++) {
			var telefoneModel = telefone.get(i);
			telefoneModel.setTelefone(empregado_dto.telefone().get(i).getTelefone());
			// System.out.println(empregado_dto.alergia().get(i).getAlergia());

		}
		
		problemaSaudeModel problSaudeExample = new problemaSaudeModel();
		problSaudeExample.setEmpregado(empregadoModel);

		Example<problemaSaudeModel> exampleProblSaude = Example.of(problSaudeExample);

		List<problemaSaudeModel> problSaude = problsaude_repository.findAll(exampleProblSaude);
		
		for (int i = 0; i < problSaude.size(); i++) {
			var problSaudeModel = problSaude.get(i);
			problSaudeModel.setProblsaude(empregado_dto.problsaude().get(i).getProblsaude());
			// System.out.println(empregado_dto.alergia().get(i).getAlergia());

		}
		
		
		 empregadoModel.setEmail(empregado_dto.email());
		 empregadoModel.setEmpregado(empregado_dto.empregado());

		return ResponseEntity.status(HttpStatus.OK).body(empregados_repository.save(empregadoModel));
	}

	@DeleteMapping("/empregados/{id}")
	public ResponseEntity<Object> deletarEmpregado(@PathVariable(value = "id") Integer id) {
		Optional<empregadoModel> empregado = empregados_repository.findById(id);
		if (empregado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empregado não encontrado.");
		}
		empregados_repository.delete(empregado.get());
		return ResponseEntity.status(HttpStatus.OK).body("O empregado foi excluído da base de dados");
	}

}
