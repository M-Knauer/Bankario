package com.marcelo.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcelo.main.dto.ContaCorrenteDTO;
import com.marcelo.main.repositories.ContaCorrenteRepository;
import com.marcelo.main.services.exceptions.ResourceNotFoundException;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository repo;
	
	@Transactional(readOnly = true)
	public ContaCorrenteDTO buscarPorId(Long id) {
		return repo.buscarPorId(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
	}
}
