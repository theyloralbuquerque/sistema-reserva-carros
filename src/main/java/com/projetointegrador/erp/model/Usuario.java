package com.projetointegrador.erp.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@NotEmpty
	@Column(nullable = false, length = 50)
	private String email;
	
	@NotEmpty
	@Column(nullable = false, length = 50)
	private String senha;
	
	@NotEmpty
	@Column(nullable = false, length = 50)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	@Digits(integer = 1, fraction = 0)
	private Integer ativo; 

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "data_cadastro", nullable = false)
	private Instant dataCadastro;

	/*
	@OneToMany(mappedBy = "cliente") // um-para-muitos.
	private Set<Carro> carros = new HashSet<>();
	*/
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public Usuario() {
	}

	public Usuario(Long idUsuario, String email, String senha, String nome, Integer ativo, Date dataNascimento) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.ativo = ativo;
		this.dataNascimento = dataNascimento;
		dataCadastro = Instant.now();
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = Instant.now();
	}
	
	/*
	public Set<Carro> getCarros() {
		return carros;
	}
	*/
	
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(idUsuario, other.idUsuario);
	}
}
