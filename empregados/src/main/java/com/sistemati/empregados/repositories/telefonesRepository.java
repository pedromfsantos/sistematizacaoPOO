package com.sistemati.empregados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemati.empregados.models.telefoneModel;

@Repository
public interface telefonesRepository extends JpaRepository<telefoneModel, Integer>{

}


