package com.sistemati.empregados.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefones")
public class telefoneModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tel;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="id_fk")
    private empregadoModel empregado;
    
	private String telefone;
	

	public empregadoModel getEmpregado() {
		return empregado;
	}

	public void setEmpregado(empregadoModel empregado) {
		this.empregado = empregado;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId_tel() {
		return id_tel;
	}

	public void setId_tel(Integer id_tel) {
		this.id_tel = id_tel;
	}
	
	public telefoneModel() {}
	   
	public telefoneModel(String telefone) {
		super();
		this.telefone = telefone;
	}
}
