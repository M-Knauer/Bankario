package com.marcelo.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.main.dto.PessoaMinDTO;
import com.marcelo.main.entities.Pessoa;
import com.marcelo.main.projections.ClientMinProjection;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


	@Query(nativeQuery = true, value =  """
			SELECT name, cpf, email, fixo, celular
			FROM tb_client c 
			INNER JOIN tb_telefone t ON c.id = t.client_id 
			WHERE c.id = :id
			""")
	Optional<ClientMinProjection> buscarPorId(Long id);
}
