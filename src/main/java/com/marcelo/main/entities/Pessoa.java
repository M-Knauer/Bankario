package com.marcelo.main.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.marcelo.main.dto.PessoaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private LocalDate birthDate;
	private String email;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Telefone> telefones = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "conta_corrente_id")
	private ContaCorrente contaCorrente;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_login_id")
	private User user;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Long id, String name, String cpf, LocalDate birthDate, String email, Endereco endereco,
			ContaCorrente contaCorrente, User user) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.email = email;
		this.endereco = endereco;
		this.contaCorrente = contaCorrente;
		this.user = user;
	}

	public Pessoa(PessoaDTO dto) {
		name = dto.name();
		cpf = dto.cpf();
		birthDate = dto.birthDate();
		email = dto.email();
		endereco = new Endereco(dto.endereco());
		//contaCorrente = new ContaCorrente(dto.contaCorrente());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public User getContaLogin() {
		return user;
	}

	public void setContaLogin(User user) {
		this.user = user;
	}
	
}
