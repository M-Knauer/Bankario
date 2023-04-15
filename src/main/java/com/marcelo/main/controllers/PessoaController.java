package com.marcelo.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.main.dto.PessoaMinDTO;
import com.marcelo.main.services.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping("{id}")
	public ResponseEntity<PessoaMinDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.buscarPorId(id));
	}
}
