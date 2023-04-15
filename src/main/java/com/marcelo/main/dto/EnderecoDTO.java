package com.marcelo.main.dto;

import com.marcelo.main.entities.Endereco;

public record EnderecoDTO(
		Long id,
		String uf,
		String localidade,
		String bairro,
		String logradouro,
		String numero,
		String cep,
		String complemento
	) {
	
	public EnderecoDTO(Endereco entity) {
		this(
				entity.getId(),
				entity.getUf(),
				entity.getLocalidade(),
				entity.getBairro(),
				entity.getLogradouro(),
				entity.getNumero(),
				entity.getCep(),
				entity.getComplemento()
				);
	}

}
