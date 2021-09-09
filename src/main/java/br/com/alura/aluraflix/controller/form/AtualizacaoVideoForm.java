package br.com.alura.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.aluraflix.modelo.Video;
import br.com.alura.aluraflix.repository.VideoRepository;

public class AtualizacaoVideoForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 3)
	private String descricao;

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

	public Video atualizar(Long id, VideoRepository videoRepository) {
		Video video = videoRepository.getOne(id);
		
		video.setTitulo(this.titulo);
		video.setDescricao(this.descricao);
		
		return video;
	}
	
	
}
