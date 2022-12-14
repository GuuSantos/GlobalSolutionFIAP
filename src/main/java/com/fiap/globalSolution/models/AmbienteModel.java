package com.fiap.globalSolution.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ambiente")
public class AmbienteModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "temperatura")
	private String temperatura;
	
	@Column(name = "qualidade_ar")
	private String qualidadeAr;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ambiente_id")
    private AmbienteModel ambiente;
	
	public AmbienteModel(Long id, String bairro, String cidade, String estado, String temperatura, String qualidadeAr) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.temperatura = temperatura;
		this.qualidadeAr = qualidadeAr;
	}
	
	public AmbienteModel() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "AmbienteModel [id=" + id + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", temperatura=" + temperatura + ", qualidadeAr=" + qualidadeAr + ", ambiente=" + ambiente + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getQualidadeAr() {
		return qualidadeAr;
	}

	public void setQualidadeAr(String qualidadeAr) {
		this.qualidadeAr = qualidadeAr;
	}
	
	
	
}
