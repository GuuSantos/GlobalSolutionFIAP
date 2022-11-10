package com.fiap.globalSolution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.globalSolution.models.VeiculoModel;


@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {

}
