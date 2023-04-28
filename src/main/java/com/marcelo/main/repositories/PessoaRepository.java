package com.marcelo.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcelo.main.dto.PessoaMinDTO;
import com.marcelo.main.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("SELECT c "
            + "FROM Pessoa c "
            + "LEFT JOIN FETCH c.telefones t "
            + "WHERE c.id = :id")
    Optional<PessoaMinDTO> buscarPorId(@Param("id") Long id);
	
	@Query("""
			SELECT p 
			FROM Pessoa p
			WHERE p.cpf = :cpf
			""")
	Optional<Pessoa> buscarPorCpf(String cpf);
}