package com.walbety.apipessoas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walbety.apipessoas.domain.entities.Pessoa;
import com.walbety.apipessoas.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping
	public List findAll(){
		return pessoaService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(pessoaService.findById(id));
	}
	
	@PostMapping
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable("id") Integer id, @RequestBody Pessoa pessoa){
		pessoa = pessoaService.update(id, pessoa);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
