package com.br.zup.exercicio.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.exercicio.api.exceptions.FilmeNaoEncontradoException;
import com.br.zup.exercicio.api.models.Filme;
import com.br.zup.exercicio.api.repositories.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Iterable<Filme> pegarTodosOsFilmes() {
		return filmeRepository.findAll();
	}
	
	public Filme pegarFilmePorID(int id) {
		return filmeRepository.findById(id).get();
	}
	
	public void adicionarFilme(Filme filme) {
		filmeRepository.save(filme);
	}
	
	public Long quantidadeDeFilmes() {
		return filmeRepository.count();
	}
	
	public void alterarFilme(int id, Filme filme) {
		Optional<Filme> optionalFilme = filmeRepository.findById(id);
		if(!optionalFilme.isPresent()) {
			throw new FilmeNaoEncontradoException("Não há filme com esse id");
		}
		filme.setId(id);
		filmeRepository.save(filme);
	}
	
	public void apagarFilme(int id) {
		filmeRepository.deleteById(id);
	}
	
	public void alugar(int id) {
		Filme filme = filmeRepository.findById(id).get();
		filme.setQuantidadeDisponivel(-1);
		filme.setId(id);
		filmeRepository.save(filme);
	}
	
	public void devolver(int id) {
		Filme filme = filmeRepository.findById(id).get();
		filme.setQuantidadeDisponivel(+1);
		filme.setId(id);
		filmeRepository.save(filme);
	}
	
}
