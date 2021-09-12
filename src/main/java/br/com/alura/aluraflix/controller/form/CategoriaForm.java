package br.com.alura.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.aluraflix.modelo.Categoria;


public class CategoriaForm {
	
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String cor;

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
	
	public Categoria converter( ) {
		return new Categoria(nome, cor);
	}
}
