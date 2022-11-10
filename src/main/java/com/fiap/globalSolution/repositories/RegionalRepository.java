package com.fiap.globalSolution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.globalSolution.models.RegionalModel;

@Repository
public interface RegionalRepository extends JpaRepository<RegionalModel, Integer>{

}
