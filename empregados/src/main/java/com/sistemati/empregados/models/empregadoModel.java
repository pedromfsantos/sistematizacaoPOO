package com.sistemati.empregados.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empregados")
public class empregadoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	

	private String empregado;
	private String email;
	
	@OneToMany(mappedBy="empregadoTel")
	Set<telefoneModel> telefone;
	

	@OneToMany(mappedBy="empregadoAlergia")
	Set<alergiaModel> alergias;
	
	@OneToMany(mappedBy="empregadoProbl")
	Set<problemaSaudeModel> problemasMedicos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpregado() {
		return empregado;
	}
	public void setEmpregado(String empregado) {
		this.empregado = empregado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<telefoneModel> getTelefone() {
		return telefone;
	}
	public void setTelefone(Set<telefoneModel> telefone) {
		this.telefone = telefone;
	}
	public Set<problemaSaudeModel> getProblemasMedicos() {
		return problemasMedicos;
	}
	public void setProblemasMedicos(Set<problemaSaudeModel> problemasMedicos) {
		this.problemasMedicos = problemasMedicos;
	}
	public Set<alergiaModel> getAlergias() {
		return alergias;
	}
	public void setAlergias(Set<alergiaModel> alergias) {
		this.alergias = alergias;
	}


}
