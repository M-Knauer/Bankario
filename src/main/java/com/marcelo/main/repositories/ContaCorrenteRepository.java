package com.marcelo.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.main.dto.ContaCorrenteDTO;
import com.marcelo.main.entities.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

	@Query(""" 
			SELECT new com.marcelo.main.dto.ContaCorrenteDTO(cc.id, cc.contaCorrente, cc.agencia, cc.saldo) 
			FROM ContaCorrente cc 
			WHERE id = :id
			""")
	Optional<ContaCorrenteDTO> buscarPorId(Long id);
}
