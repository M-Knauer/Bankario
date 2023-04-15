package com.marcelo.main.dto;

import com.marcelo.main.entities.ContaCorrente;

public record ContaCorrenteDTO(
		Long id, 
		String contaCorrente, 
		String agencia, 
		Double saldo
		
		) {
	
	public ContaCorrenteDTO(ContaCorrente entity) {
		this(
				entity.getId(),
				entity.getContaCorrente(),
				entity.getAgencia(),
				entity.getSaldo()
				);
	}
	
}
