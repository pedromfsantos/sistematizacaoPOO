package com.sistemati.empregados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemati.empregados.models.alergiaModel;

@Repository
public interface alergiasRepository extends JpaRepository<alergiaModel, Integer>{

}
