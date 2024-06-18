package com.sistemati.empregados.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	

	private String empregado;
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="empregado", cascade=CascadeType.ALL)
	private List<telefoneModel> telefone;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="empregado", cascade=CascadeType.ALL)
	private List<alergiaModel> alergia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="empregado", cascade=CascadeType.ALL)
	private List<problemaSaudeModel> problsaude;
	

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
	
	
	public List<problemaSaudeModel> getProblsaude() {
		return problsaude;
	}
	public void setProblsaude(List<problemaSaudeModel> problsaude) {
		this.problsaude = problsaude;
	}

	
	public List<alergiaModel> getAlergia() {
		return alergia;
	}
	public void setAlergia(List<alergiaModel> alergia) {
		this.alergia = alergia;
	}
	

	
	public empregadoModel(String empregado, String email) {
		this.empregado = empregado;
		this.email = email;
	}
	
	public empregadoModel() {}
	
	
}
	

