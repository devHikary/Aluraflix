package br.com.alura.aluraflix.controller.form;

import br.com.alura.aluraflix.modelo.Video;

public class VideoForm {

	private String titulo;
	private String descricao;
	private String url;
	
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
	
	public Video converter() {
		return new Video(titulo, descricao, url);
	}
	
	
}
