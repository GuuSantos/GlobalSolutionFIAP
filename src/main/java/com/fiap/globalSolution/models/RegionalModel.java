package com.fiap.globalSolution.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_regional")
public class RegionalModel {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "data_operacao")
	private LocalDate dataOperacao;
	
	@OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_veiculos")
    private List<VeiculoModel> veiculos;

	public RegionalModel(Long id, LocalDate dataOperacao, List<VeiculoModel> veiculos) {
		super();
		this.id = id;
		this.dataOperacao = dataOperacao;
		this.veiculos = veiculos;
	}
	
	public RegionalModel() {
		
	}
	
	

	@Override
	public String toString() {
		return "RegionalModel [id=" + id + ", dataOperacao=" + dataOperacao + ", veiculos=" + veiculos + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public List<VeiculoModel> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoModel> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
}
