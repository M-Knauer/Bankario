package com.marcelo.main.dto;

import com.marcelo.main.entities.Telefone;
import com.marcelo.main.projections.TelefoneMinProjection;

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
	
	public TelefoneMinDTO(TelefoneMinProjection entity) {
		this(
				entity.getFixo(),
				entity.getCelular()
				);
	}
}
