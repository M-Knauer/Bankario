package com.marcelo.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.main.dto.ContaCorrenteDTO;
import com.marcelo.main.services.ContaCorrenteService;

@RestController
@RequestMapping("contas")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService service;
	
	@GetMapping("/{id}")
	public ContaCorrenteDTO findById(@PathVariable Long id) {
		
		return service.buscarPorId(id);
	}
}
