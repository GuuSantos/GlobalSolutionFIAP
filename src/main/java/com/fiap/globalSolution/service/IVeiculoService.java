package com.fiap.globalSolution.service;

import org.springframework.http.ResponseEntity;

import com.fiap.globalSolution.models.VeiculoModel;

public interface IVeiculoService {
	
	 public ResponseEntity saveVeiculo(VeiculoModel veiculo);
}
