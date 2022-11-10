package com.fiap.globalSolution.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fiap.globalSolution.models.AmbienteModel;
import com.fiap.globalSolution.models.RegionalModel;
import com.fiap.globalSolution.models.VeiculoModel;
import com.fiap.globalSolution.repositories.AmbienteRepository;
import com.fiap.globalSolution.repositories.RegionalRepository;
import com.fiap.globalSolution.repositories.VeiculoRepository;

import java.util.List;


@Service
public class VeiculoService implements IVeiculoService{

    @Autowired
    public RegionalRepository regionalRepository;
    
    @Autowired
    public AmbienteRepository ambienteRepository;
    
    @Autowired
    public VeiculoRepository veiculoRepository;
    

	@Override
	public ResponseEntity saveVeiculo(VeiculoModel veiculo) {
		
		try{
			AmbienteModel ambiente = new AmbienteModel();
			RegionalModel regional = new RegionalModel();
			
			List<VeiculoModel> veiculos = new ArrayList<>();
			veiculos.add(veiculoRepository.save(veiculo));
			
			regional.setVeiculos(veiculos);
			regionalRepository.save(regional);
			return ResponseEntity.ok(veiculo.toString() + ambiente.toString() + regional.toString());
		}catch(Exception ex) {
			return ResponseEntity.internalServerError().body(ex);
		}

	}

}
