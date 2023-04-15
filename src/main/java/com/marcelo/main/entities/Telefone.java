package com.marcelo.main.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fixo;
	private String celular;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonBackReference
	private Pessoa client;
	
	public Telefone() {

	}

	public Telefone(Long id, String fixo, String celular, Pessoa client) {
		this.id = id;
		this.fixo = fixo;
		this.celular = celular;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Pessoa getClient() {
		return client;
	}

	public void setClient(Pessoa client) {
		this.client = client;
	}

}
