package com.walbety.apipessoas.service;

import java.util.List;

import com.walbety.apipessoas.domain.entities.Pessoa;

public interface PessoaService {

	public List<Pessoa> findAll();
	public Pessoa save(Pessoa pessoa);
	public Pessoa update(Integer id, Pessoa pessoa);
	public Pessoa findById(Integer id);
	public void delete(Integer id);

}
