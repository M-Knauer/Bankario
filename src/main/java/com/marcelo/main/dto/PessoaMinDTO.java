package com.marcelo.main.dto;

import java.util.List;

import com.marcelo.main.entities.Pessoa;
import com.marcelo.main.projections.ClientMinProjection;

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
	
	
	public PessoaMinDTO(ClientMinProjection entity) {
		this(
				entity.getName(),
				entity.getCpf(),
				entity.getEmail(),
				entity.getTelefones().stream().map(TelefoneMinDTO::new).toList()
				);
	}

	
}
