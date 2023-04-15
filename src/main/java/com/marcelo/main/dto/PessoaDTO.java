package com.marcelo.main.dto;

import java.time.LocalDate;
import java.util.Set;

import com.marcelo.main.entities.Pessoa;
import com.marcelo.main.entities.Telefone;

public record PessoaDTO(
		Long id, 
		String name, 
		String cpf, 
		LocalDate birthDate, 
		String email, 
		String senha,
		EnderecoDTO endereco,
		ContaCorrenteDTO contaCorrente,
		Set<Telefone> telefones
		) {

	public PessoaDTO(Pessoa entity) {
		this(
				entity.getId(),
				entity.getName(),
				entity.getCpf(),
				entity.getBirthDate(),
				entity.getEmail(),
				entity.getSenha(),
				new EnderecoDTO(entity.getEndereco()),
				new ContaCorrenteDTO(entity.getContaCorrente()),
				entity.getTelefones()
				);
	}
	
}
