package com.sistemati.empregados.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alergias")
public class alergiaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_alergia;
	
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private empregadoModel alergia;
    
    public Integer getId_alergia() {
		return id_alergia;
	}

	public void setId_alergia(Integer id_alergia) {
		this.id_alergia = id_alergia;
	}

	public empregadoModel getAlergia() {
		return alergia;
	}

	public void setAlergia(empregadoModel alergia) {
		this.alergia = alergia;
	}

	public alergiaModel() {}
    
    

}
