package com.sistemati.empregados.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
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
	
	@OneToMany(mappedBy="telefone", cascade=CascadeType.PERSIST)
	private List<telefoneModel> telefone;
	
	@OneToMany(mappedBy="alergia", cascade=CascadeType.PERSIST)
	private List<alergiaModel> alergia;
	
	@OneToMany(mappedBy="problemasaude", cascade=CascadeType.PERSIST)
	private List<problemaSaudeModel> problemasaude;
	

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
	
	public List<telefoneModel> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<telefoneModel> telefone) {
		this.telefone = telefone;
	}

	public List<alergiaModel> getAlergia() {
		return alergia;
	}
	public void setAlergia(List<alergiaModel> alergia) {
		this.alergia = alergia;
	}
	public List<problemaSaudeModel> getProblemasaude() {
		return problemasaude;
	}
	public void setProblemasaude(List<problemaSaudeModel> problemasaude) {
		this.problemasaude = problemasaude;
	}

}
