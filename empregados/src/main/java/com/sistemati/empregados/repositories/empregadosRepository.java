package com.sistemati.empregados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemati.empregados.models.empregadoModel;

@Repository
public interface empregadosRepository extends JpaRepository<empregadoModel, Integer>{
	

}
