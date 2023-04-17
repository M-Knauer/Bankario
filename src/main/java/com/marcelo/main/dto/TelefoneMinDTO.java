package com.marcelo.main.dto;

import com.marcelo.main.entities.Telefone;

public record TelefoneMinDTO(
		
		String fixo,
		String celular
		
		) {
	
	public TelefoneMinDTO(Telefone entity) {
		this(
				entity.getFixo(),
				entity.getCelular()
				);
	}
	
}
