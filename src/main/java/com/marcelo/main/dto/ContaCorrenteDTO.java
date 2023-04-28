package com.marcelo.main.dto;

import com.marcelo.main.entities.ContaCorrente;
import com.marcelo.main.entities.Pessoa;

public record ContaCorrenteDTO(
		Long id, 
		String contaCorrente, 
		String agencia, 
		Double saldo,
		Pessoa client
		) {
	
	public ContaCorrenteDTO(ContaCorrente entity) {
		this(
				entity.getId(),
				entity.getContaCorrente(),
				entity.getAgencia(),
				entity.getSaldo(),
				entity.getClient()
				);
	}
	
}
