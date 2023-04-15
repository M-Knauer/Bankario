package com.marcelo.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.main.dto.ContaCorrenteDTO;
import com.marcelo.main.repositories.ContaCorrenteRepository;

@RestController
@RequestMapping("conta")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteRepository repo;
	
	@GetMapping("/{id}")
	public ContaCorrenteDTO findById(@PathVariable Long id) {
		
		return repo.buscarPorId(id).get();
	}
}
