package com.br.zup.exercicio.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.exercicio.api.models.Filme;
import com.br.zup.exercicio.api.services.FilmeService;

//CORS
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filme")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;
	
	@GetMapping
	public ResponseEntity mostrarFilmes() {
		if(filmeService.quantidadeDeFilmes() > 0) {
			return ResponseEntity.ok(filmeService.pegarTodosOsFilmes());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> mostrarFilmePorID(@PathVariable int id) {
		try {
			Filme filme = filmeService.pegarFilmePorID(id);
			return ResponseEntity.ok(filme);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Filme> adicionarFilme(@Valid @RequestBody Filme filme) {
		filmeService.adicionarFilme(filme);
		return ResponseEntity.status(HttpStatus.CREATED).body(filme);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarFilme(@PathVariable int id) {
		try {
			filmeService.apagarFilme(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarFilme(@PathVariable int id, @Valid @RequestBody Filme filme) {
		filmeService.alterarFilme(id, filme);
		return ResponseEntity.ok().build();
	}
	
}
