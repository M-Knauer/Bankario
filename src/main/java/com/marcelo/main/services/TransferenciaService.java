package com.marcelo.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcelo.main.entities.User;
import com.marcelo.main.repositories.UserRepository;
import com.marcelo.main.security.config.SecurityFilter;
import com.marcelo.main.security.config.TokenService;
import com.marcelo.main.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class TransferenciaService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private SecurityFilter token;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Transactional
	public void deposito(Double amount) {
		
		Long id = tokenService.getIdFromToken(token.retriveToken(request));
		
		User entity = repo.getReferenceById(id);
	
		entity.getClient().getContaCorrente().depositar(amount);
		
	}
	
	@Transactional
	public void saque(Double amount) {
		
		Long id = tokenService.getIdFromToken(token.retriveToken(request));
		
		User entity = repo.getReferenceById(id);
		
		entity.getClient().getContaCorrente().sacar(amount);
		
	}
}
