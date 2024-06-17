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
@Table(name = "telefones")
public class telefoneModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tel;
	

	@ManyToOne
    @JoinColumn(name="id_fk", nullable=false)
    private empregadoModel telefone;
    


	public empregadoModel getTelefone() {
		return telefone;
	}

    public Integer getId_tel() {
		return id_tel;
	}



	public void setId_tel(Integer id_tel) {
		this.id_tel = id_tel;
	}


	public void setTelefone(empregadoModel telefone) {
		this.telefone = telefone;
	}



	public telefoneModel() {}
   


    

}
