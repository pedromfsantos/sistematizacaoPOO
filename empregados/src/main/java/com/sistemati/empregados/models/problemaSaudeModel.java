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
@Table(name = "problemassaude")
public class problemaSaudeModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_problsaude;
	
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private empregadoModel problemasaude;
    
    public Integer getId_problsaude() {
		return id_problsaude;
	}

	public void setId_problsaude(Integer id_problsaude) {
		this.id_problsaude = id_problsaude;
	}

	public empregadoModel getProblemasaude() {
		return problemasaude;
	}

	public void setProblemasaude(empregadoModel problemasaude) {
		this.problemasaude = problemasaude;
	}

	public problemaSaudeModel() {}
    


    

}
