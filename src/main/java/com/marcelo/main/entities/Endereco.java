package com.marcelo.main.entities;

import java.io.Serializable;

import com.marcelo.main.dto.EnderecoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String uf;
	private String localidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	
	@OneToOne(mappedBy = "endereco")
	private Pessoa client;
	
	public Endereco() {

	}

	public Endereco(Long id, String uf, String localidade, String bairro, String logradouro, String numero, String cep,
			String complemento) {
		this.id = id;
		this.uf = uf;
		this.localidade = localidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
	}
	
	public Endereco(EnderecoDTO dto) {
		uf = dto.uf();
		localidade = dto.localidade();
		bairro = dto.bairro();
		logradouro = dto.logradouro();
		numero = dto.numero();
		cep = dto.cep();
		complemento = dto.complemento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
