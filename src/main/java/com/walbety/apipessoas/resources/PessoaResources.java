package com.walbety.apipessoas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walbety.apipessoas.entities.Pessoa;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResources {

	@GetMapping
	public ResponseEntity<Pessoa> findAll(){
		Pessoa pessoa = new Pessoa("Carlos", 20);
		return ResponseEntity.ok().body(pessoa);
	}
	
	
}
