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

import com.fiap.globalSolution.models.RegionalModel;
import com.fiap.globalSolution.repositories.RegionalRepository;

@RestController
@RequestMapping("/regiao")
public class RegionalController {
	
	@Autowired
	private RegionalRepository regionalRepository;
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/listaRegioes")
	public ResponseEntity<List<RegionalModel>> getRegioes(){
		List<RegionalModel> listaRegioes = regionalRepository.findAll();
		return new ResponseEntity<List<RegionalModel>>(listaRegioes, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<RegionalModel> postRegional(@RequestBody RegionalModel regional){
		regionalRepository.save(regional);
		return new ResponseEntity<RegionalModel>(regional, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(path = "/regiao/{id}")
    public ResponseEntity updateRegional(@RequestBody RegionalModel regional){
        return ResponseEntity.status(HttpStatus.OK).body(regionalRepository.save(regional));
    }
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(path = "/regiao/{id}")
    public ResponseEntity deleteRegional(@PathVariable Integer id){
		regionalRepository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
