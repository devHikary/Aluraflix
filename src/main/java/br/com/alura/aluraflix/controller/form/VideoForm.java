package br.com.alura.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.aluraflix.modelo.Categoria;
import br.com.alura.aluraflix.modelo.Video;
import br.com.alura.aluraflix.repository.CategoriaRepository;

public class VideoForm {

	@NotNull @NotEmpty @Length(min = 3)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String descricao;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String url;
	
	@NotNull @NotEmpty 
	private String nomeCategoria;
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getUrl() {
		return url;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public Video converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);

		return new Video(titulo, descricao, url, categoria);
	}
	
	
}
