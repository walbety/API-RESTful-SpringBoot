package com.walbety.apipessoas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walbety.apipessoas.domain.entities.Pessoa;
import com.walbety.apipessoas.domain.repositories.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	private PessoaRepository repository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		this.repository = pessoaRepository;
	}

	@GetMapping
	public List findAll(){
		return repository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record)) // o .ok() retorna HTTP 200
				.orElse(ResponseEntity.notFound().build()); // o .notFound() retorna HTTP 404
	}
	
	@PostMapping
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> update(@PathVariable("id") Integer id, @RequestBody Pessoa pessoa){
		return repository.findById(id)
				.map(record -> {
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
					
					Pessoa pessoaAtualizada = repository.save(pessoa);
					return ResponseEntity.ok().body(pessoaAtualizada);}).orElse(ResponseEntity.notFound().build());
	}
	
}
