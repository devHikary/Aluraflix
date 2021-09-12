package br.com.alura.aluraflix.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.aluraflix.modelo.Categoria;

public class CategoriaDto {

	private Long id;
	private String nome;
	private String cor;	
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.cor = categoria.getCor();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public static List<CategoriaDto> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
}
