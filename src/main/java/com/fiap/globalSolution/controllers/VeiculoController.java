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

import com.fiap.globalSolution.models.VeiculoModel;
import com.fiap.globalSolution.repositories.VeiculoRepository;
import com.fiap.globalSolution.service.VeiculoService;



@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(path = "/veiculo")
    public ResponseEntity postVeiculo(@RequestBody VeiculoModel veiculo){
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.saveVeiculo(veiculo));
    }
	
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping(path = "/listaVeiculos")
	public ResponseEntity<List<VeiculoModel>> listarVeiculos() {
		List<VeiculoModel> listaVeiculos = veiculoRepository.findAll();

		return new ResponseEntity<List<VeiculoModel>>(listaVeiculos, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping(path = "/veiculo/{id}")
    public ResponseEntity getVeiculoById(@PathVariable Long id){
        return veiculoRepository.findById(id)
        		.map(ResponseEntity::ok)
        		.orElse(ResponseEntity.notFound().build());
    }
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(path = "/veiculo/{id}")
    public ResponseEntity updateVeiculo(@RequestBody VeiculoModel veiculo){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculo));
    }
	
	@DeleteMapping(path = "/veiculo/{id}")
    public ResponseEntity deleteVeiculo(@PathVariable Long id){
        veiculoRepository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
