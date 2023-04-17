package com.marcelo.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.main.dto.PessoaMinDTO;
import com.marcelo.main.repositories.PessoaRepository;
import com.marcelo.main.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	public PessoaMinDTO buscarPorId(Long id) {
		
		return repo.buscarPorId(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		
	}
}

