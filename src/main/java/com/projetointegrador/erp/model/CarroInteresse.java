package com.projetointegrador.erp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "carro_interesse")
public class CarroInteresse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_interessado")
	private Long idInteressado;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private MarcaCarro marca;
	
	@Column(name = "modelo", nullable = false, length = 20)
	private String modelo;
	
	@Column(name = "ano_fabricacao", nullable = false)
	@Digits(integer = 4, fraction = 0)
	private Integer anoFabricacao;

	@Column(name = "ano_modelo", nullable = false)
	@Digits(integer = 4, fraction = 0)
	private Integer anoModelo;
	
	private Double valor;
	
	@Column(name = "descricao", length = 200)
	private String descricao;
	
	@Column(name = "nome_interessado", length = 50)
	private String nomeInteressado;

	@Column(name = "whatsapp", length = 11)
	private String whatsapp;
	
	@OneToOne // one-para-um.
	@JoinColumn(name = "id_carro") // Define a coluna id_carro como FK na tabela Carro.
	private Carro idCarro;
	
	public Long getIdInteressado() {
		return idInteressado;
	}
	
	public void setIdInteressadoo(Long idInteressado) {
		this.idInteressado = idInteressado;
	}
	
	public MarcaCarro getMarca() {
		return marca;
	}
	
	public void setMarca(MarcaCarro marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public Integer getAnoModelo() {
		return anoModelo;
	}
	
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNomeInteressado() {
		return nomeInteressado;
	}

	public void setNomeInteressado(String nomeInteressado) {
		this.nomeInteressado = nomeInteressado;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idInteressado);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarroInteresse other = (CarroInteresse) obj;
		return Objects.equals(idInteressado, other.idInteressado);
	}
}
