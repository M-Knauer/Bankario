package com.marcelo.main.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta_corrente")
public class ContaCorrente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contaCorrente;
	private String agencia;
	private Double saldo;
	
	@OneToOne(mappedBy = "contaCorrente")
	private Pessoa client;
	
	public ContaCorrente() {

	}

	public ContaCorrente(Long id, String contaCorrente, String agencia, Double saldo) {
		super();
		this.id = id;
		this.contaCorrente = contaCorrente;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(Double qtd) {
		saldo += (qtd > 0 ? qtd : 0);
	}
	
}