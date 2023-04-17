package com.marcelo.main.dto;

import java.util.List;

import com.marcelo.main.entities.Pessoa;

public record PessoaMinDTO(
		String name, 
		String cpf, 
		String email,
		List<TelefoneMinDTO> telefones
		) {

	public PessoaMinDTO(Pessoa entity) {
		this(
				entity.getName(),
				entity.getCpf(),
				entity.getEmail(),
				entity.getTelefones().stream().map(TelefoneMinDTO::new).toList()
				);
	}
	
	public PessoaMinDTO(String name, String cpf, String email, List<TelefoneMinDTO> telefones) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.telefones = telefones;
	}
	
}