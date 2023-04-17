package com.marcelo.main.dto;

import java.util.ArrayList;
import java.util.List;

import com.marcelo.main.entities.Pessoa;

public class PessoaMinClassDTO {

	private String name;
	private String cpf;
	private String email;
	private List<TelefoneMinDTO> telefones = new ArrayList<>();

	public PessoaMinClassDTO(Pessoa entity) {
		name = entity.getName();
		cpf = entity.getCpf();
		email =  entity.getEmail();
		entity.getTelefones().forEach(x -> telefones.add(new TelefoneMinDTO(x)));
	}

	public PessoaMinClassDTO(String name, String cpf, String email, String fixo, String celular) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		telefones.add(new TelefoneMinDTO(fixo, celular));
	}
	
	public PessoaMinClassDTO() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TelefoneMinDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneMinDTO> telefones) {
		this.telefones = telefones;
	}
	
}