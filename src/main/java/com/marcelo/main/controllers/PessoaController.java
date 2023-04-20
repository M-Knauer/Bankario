package com.marcelo.main.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.main.dto.PessoaDTO;
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
	
	
	@PutMapping("{id}")
	public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
		return ResponseEntity.ok().body(service.update(id, dto));
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> cadastar(@RequestBody PessoaDTO dto) {
		dto = service.cadastrar(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        
		return ResponseEntity.created(uri).body(dto);
	}
}
