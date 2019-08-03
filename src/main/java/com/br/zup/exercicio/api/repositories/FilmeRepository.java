package com.br.zup.exercicio.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.exercicio.api.models.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

}
