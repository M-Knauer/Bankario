package com.marcelo.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcelo.main.dto.PessoaDTO;
import com.marcelo.main.dto.PessoaMinDTO;
import com.marcelo.main.dto.TelefoneDTO;
import com.marcelo.main.entities.ContaCorrente;
import com.marcelo.main.entities.Endereco;
import com.marcelo.main.entities.Pessoa;
import com.marcelo.main.entities.Telefone;
import com.marcelo.main.entities.User;
import com.marcelo.main.repositories.EnderecoRepository;
import com.marcelo.main.repositories.PessoaRepository;
import com.marcelo.main.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public PessoaMinDTO buscarPorId(Long id) {
		PessoaMinDTO dto = repo.buscarPorId(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return dto;
		
	}
	
	@Transactional
	public PessoaDTO cadastrar(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		
		entity.setName(dto.name());
		entity.setCpf(dto.cpf());
		entity.setEmail(dto.email());
		entity.setBirthDate(dto.birthDate());
		
		toEntity(dto, entity);
		
		return new PessoaDTO(repo.save(entity));
	}
	
	@Transactional
	public PessoaDTO update(Long id, PessoaDTO dto) {
		try {
			Pessoa entity = repo.getReferenceById(id);
			
			entity.setEmail(dto.email());
			
			toEntity(dto, entity);
			
			return new PessoaDTO(repo.save(entity));
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}

	private void toEntity(PessoaDTO dto, Pessoa entity) {
		// endereço
		Endereco endereco = new Endereco();
		
		if (entity.getEndereco() != null) {
			endereco = enderecoRepository.getReferenceById(entity.getEndereco().getId());	
		}
		
		setEndereco(endereco, dto);
		entity.setEndereco(endereco);
		
		// cc
		if (entity.getContaCorrente() == null) {
			ContaCorrente cc = new ContaCorrente();
			generateCc(cc);
			entity.setContaCorrente(cc);
		}
		
		// telefone
		if (!dto.telefones().isEmpty()) {
			setTelefones(dto, entity);
		}
		
		// user
		User user = new User();
		if (entity.getContaLogin() == null) {
			setUser(dto, user);
		}
		
		entity.setContaLogin(user);
			
	}
	
	private void setEndereco(Endereco endereco, PessoaDTO dto) {
		endereco.setBairro(dto.endereco().bairro());
		endereco.setCep(dto.endereco().cep());
		endereco.setLocalidade(dto.endereco().localidade());
		endereco.setLogradouro(dto.endereco().logradouro());
		endereco.setUf(dto.endereco().uf());
		endereco.setNumero(dto.endereco().numero());
		endereco.setComplemento(dto.endereco().complemento());
	}
	
	private void generateCc(ContaCorrente cc) {
		cc.setAgencia("001");
		cc.setContaCorrente("11111-1");
		cc.setSaldo(0D);
	}
	
	private void setTelefones(PessoaDTO dto, Pessoa entity) {
		ObjectMapper mapper = new ObjectMapper();
		entity.getTelefones().clear();
		
		for (TelefoneDTO tel : mapper.convertValue(dto.telefones(), new TypeReference<List<TelefoneDTO>>() { })) {
			Telefone t = new Telefone();
			t.setCelular(tel.celular());
			t.setFixo(tel.fixo());
			t.setClient(entity);
			entity.getTelefones().add(t);
		}
	}
	
	private void setUser(PessoaDTO dto, User entity) {
		entity.setLogin(dto.cpf());
		entity.setPassword(encoder.encode(dto.user().password()));
	}
	
}
