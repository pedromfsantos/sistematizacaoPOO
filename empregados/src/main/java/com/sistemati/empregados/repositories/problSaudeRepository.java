package com.sistemati.empregados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemati.empregados.models.problemaSaudeModel;

@Repository
public interface problSaudeRepository extends JpaRepository<problemaSaudeModel, Integer>{

}



