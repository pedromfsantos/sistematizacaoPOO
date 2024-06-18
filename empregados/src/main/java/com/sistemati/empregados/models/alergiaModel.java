package com.sistemati.empregados.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "alergias")
public class alergiaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_alergia")
	private Integer id_alergia;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_fk")
    private empregadoModel empregado;
    
    private String alergia;
    
    
    public Integer getId_alergia() {
		return id_alergia;
	}
	public void setId_alergia(Integer id_alergia) {
		this.id_alergia = id_alergia;
	}


	public empregadoModel getEmpregado() {
		return empregado;
	}
	public void setEmpregado(empregadoModel empregado) {
		this.empregado = empregado;
	}

	
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	
	public alergiaModel() {}

	public alergiaModel(String alergia) {
		this.alergia = alergia;
	}
	
	
	
    
    

}
