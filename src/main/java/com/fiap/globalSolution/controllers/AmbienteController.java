package com.fiap.globalSolution.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.globalSolution.models.AmbienteModel;
import com.fiap.globalSolution.models.VeiculoModel;
import com.fiap.globalSolution.repositories.AmbienteRepository;

@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
	
	
	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/listaAmbientes")
	public ResponseEntity<List<AmbienteModel>> getAmbiente(){
		List<AmbienteModel> listaAmbientes = ambienteRepository.findAll();
		return new ResponseEntity<List<AmbienteModel>>(listaAmbientes, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<AmbienteModel> postAmbiente(@RequestBody AmbienteModel ambiente){
		ambienteRepository.save(ambiente);
		return new ResponseEntity<AmbienteModel>(ambiente, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(path = "/ambiente/{id}")
    public ResponseEntity updateAmbiente(@RequestBody AmbienteModel ambiente){
        return ResponseEntity.status(HttpStatus.OK).body(ambienteRepository.save(ambiente));
    }
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(path = "/ambiente/{id}")
    public ResponseEntity deleteVeiculo(@PathVariable Integer id){
        ambienteRepository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
