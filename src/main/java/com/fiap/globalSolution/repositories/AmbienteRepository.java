package com.fiap.globalSolution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.globalSolution.models.AmbienteModel;

@Repository
public interface AmbienteRepository extends JpaRepository<AmbienteModel, Integer>{

}
