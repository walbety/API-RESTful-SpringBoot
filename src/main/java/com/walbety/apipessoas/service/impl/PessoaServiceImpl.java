package com.walbety.apipessoas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walbety.apipessoas.domain.entities.Pessoa;
import com.walbety.apipessoas.domain.repositories.PessoaRepository;
import com.walbety.apipessoas.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepo;

	@Override
	public List<Pessoa> findAll() {
		return pessoaRepo.findAll();
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepo.save(pessoa);
	}
	
	

	@Override
	public Pessoa update(Integer id, Pessoa pessoa) {
		/*
		 * diferentemente do findById(), o getOne prepara o objeto e o monitora, podendo
		 * alterá-lo e no final fazer a alteração necessária no banco
		 */
		Pessoa record = pessoaRepo.getOne(id);
		
		record.setNome(pessoa.getNome());
		record.setAltura(pessoa.getAltura());
		record.setBairro(pessoa.getBairro());
		record.setCelular(pessoa.getCelular());
		record.setCep(pessoa.getCep());
		record.setCidade(pessoa.getCidade());
		record.setCor(pessoa.getCor());
		record.setCpf(pessoa.getCpf());
		record.setDataNasc(pessoa.getDataNasc());
		record.setEmail(pessoa.getEmail());
		record.setEndereco(pessoa.getEndereco());
		record.setEstado(pessoa.getEstado());
		record.setIdade(pessoa.getIdade());
		record.setMae(pessoa.getMae());
		record.setNumero(pessoa.getNumero());
		record.setPai(pessoa.getPai());
		record.setPeso(pessoa.getPeso());
		record.setRg(pessoa.getRg());
		record.setSenha(pessoa.getSenha());
		record.setSigno(pessoa.getSigno());
		record.setTelefoneFixo(pessoa.getTelefoneFixo());
		record.setTipoSanguineo(pessoa.getTipoSanguineo());
		
		Pessoa pessoaAtualizada = pessoaRepo.save(record);
		return pessoaAtualizada;
	}

	@Override
	public Pessoa findById(Integer id) {
		Optional<Pessoa> pessoa = pessoaRepo.findById(id);
		return pessoa.get();
	}

	@Override
	public void delete(Integer id) {
		// TODO criar tratamento de exceções
		pessoaRepo.deleteById(id);
	}
	
}
