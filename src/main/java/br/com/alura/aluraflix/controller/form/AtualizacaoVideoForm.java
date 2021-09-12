package br.com.alura.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.aluraflix.modelo.Categoria;
import br.com.alura.aluraflix.modelo.Video;
import br.com.alura.aluraflix.repository.CategoriaRepository;
import br.com.alura.aluraflix.repository.VideoRepository;

public class AtualizacaoVideoForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String descricao;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String url;
	
	private String nomeCategoria;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Video atualizar(Long id, VideoRepository videoRepository, CategoriaRepository categoriaRepository) {
		Video video = videoRepository.getOne(id);
		
		video.setTitulo(this.titulo);
		video.setDescricao(this.descricao);
		video.setUrl(this.url);
		
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		video.setCategoria(categoria);
		
		return video;
	}
	
	
}
