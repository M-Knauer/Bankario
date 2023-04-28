package com.marcelo.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcelo.main.entities.Pessoa;
import com.marcelo.main.entities.User;
import com.marcelo.main.repositories.PessoaRepository;
import com.marcelo.main.repositories.UserRepository;
import com.marcelo.main.security.config.SecurityFilter;
import com.marcelo.main.security.config.TokenService;

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
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public void deposito(Double amount) {
		User entity = retriveUser();
	
		entity.getClient().getContaCorrente().depositar(amount);
	}
	
	@Transactional
	public void saque(Double amount) {
		User entity = retriveUser();
		
		entity.getClient().getContaCorrente().sacar(amount);
	}

	@Transactional
	public void pixCpf(String cpf, Double amount) {
		User entity = retriveUser();
		Pessoa dest = pessoaRepository.buscarPorCpf(cpf).get();
		entity.getClient().getContaCorrente().sacar(amount);
		dest.getContaCorrente().depositar(amount);
	}
	
	private User retriveUser() {
		Long id = tokenService.getIdFromToken(token.retriveToken(request));
		return repo.getReferenceById(id);
	}
}
