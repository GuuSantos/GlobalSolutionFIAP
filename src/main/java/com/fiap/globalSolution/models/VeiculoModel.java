package com.fiap.globalSolution.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class VeiculoModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "placa_veiculo")
	private String placaVeiculo;
	
	@Column(name = "quilometragem")
	private double quilometragem;
	
	
	
	
	public VeiculoModel(Long id, String marca, String modelo, String placaVeiculo, double quilometragem) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placaVeiculo = placaVeiculo;
		this.quilometragem = quilometragem;
	}
	
	public VeiculoModel() {
		
	}
	


	@Override
	public String toString() {
		return "VeiculoModel [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", placaVeiculo=" + placaVeiculo
				+ ", quilometragem=" + quilometragem + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	
	
	
}
