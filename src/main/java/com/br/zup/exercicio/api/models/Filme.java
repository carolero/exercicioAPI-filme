package com.br.zup.exercicio.api.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome obrigatório")
	@NotNull
	@Size(min = 3, message = "Nome do filme precisa ter pelo menos 3 letras")
	private String nome;
	
	@NotBlank(message = "Link da capa obrigatório")
	@NotNull
	private String linkDaCapa;
	
	@NotBlank(message = "Ano é obrigatório")
	@Min(value = 4, message = "Ano precisa ter 4 números")
	private int ano;
	
	@NotBlank(message = "Duração é obrigatória")
	private int duracao;
	
	@NotBlank(message = "Gênero é obrigatório")
	@NotNull
	private String genero;
	
	private int classificacaoIndicativa;
	private int quantidadeDisponivel;
	
	public Filme() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinkDaCapa() {
		return linkDaCapa;
	}

	public void setLinkDaCapa(String linkDaCapa) {
		this.linkDaCapa = linkDaCapa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

}
