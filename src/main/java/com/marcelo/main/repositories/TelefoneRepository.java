package com.marcelo.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.main.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
