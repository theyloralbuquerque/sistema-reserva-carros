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
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "carro")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carro")
	private Long idCarro;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private MarcaCarro marca;
	
	@NotEmpty
	@Column(name = "modelo", nullable = false, length = 20)
	private String modelo;
	
	@NotNull
	@Column(name = "ano_fabricacao", nullable = false)
	@Digits(integer = 4, fraction = 0)
	private Integer anoFabricacao;
	
	@NotNull
	@Column(name = "ano_modelo", nullable = false)
	@Digits(integer = 4, fraction = 0)
	private Integer anoModelo;
	
	@NotNull
	private Double valor;
	
	@NotEmpty
	@Column(name = "descricao", length = 200)
	private String descricao;

	/*
	@ManyToOne // muitos-para-um.
	@JoinColumn(name = "id_cliente") // Define a coluna id_cliente como FK na tabela Carro.
	private Usuario cliente;
	*/
	
	public Long getIdCarro() {
		return idCarro;
	}
	
	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(idCarro);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(idCarro, other.idCarro);
	}
}
