package com.marcelo.main.dto;

import com.marcelo.main.entities.Telefone;

public record TelefoneDTO(
		
		Long id,
		String fixo,
		String celular,
		PessoaDTO client
		
		) {
	
	public TelefoneDTO(Telefone entity) {
		this(
				entity.getId(),
				entity.getFixo(),
				entity.getCelular(),
				new PessoaDTO(entity.getClient())
				);
	}
}
