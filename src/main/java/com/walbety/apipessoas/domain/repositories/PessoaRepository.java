package com.walbety.apipessoas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walbety.apipessoas.domain.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
