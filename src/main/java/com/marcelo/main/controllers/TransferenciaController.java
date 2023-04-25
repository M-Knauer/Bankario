package com.marcelo.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.main.services.TransferenciaService;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService service;
	
	@PutMapping("/deposito")
	public ResponseEntity<Void> deposito(@RequestParam(defaultValue = "0") Double amount) {
		service.deposito(amount);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/saque")
	public ResponseEntity<Void> saque(@RequestParam(defaultValue = "0") Double amount) {
		service.deposito(amount);
		return ResponseEntity.ok().build();
	}
}
