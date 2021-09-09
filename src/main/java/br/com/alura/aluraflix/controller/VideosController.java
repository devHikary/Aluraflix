package br.com.alura.aluraflix.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.aluraflix.controller.dto.VideoDto;
import br.com.alura.aluraflix.modelo.Video;
import br.com.alura.aluraflix.repository.VideoRepository;

@RestController
public class VideosController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@RequestMapping("/videos")
	public List<VideoDto> lista(String titulo) {
		if(titulo == null) {
			List<Video> videos = videoRepository.findAll();
			return VideoDto.converter(videos);
		} else {
			List<Video> videos = videoRepository.findByTitulo(titulo);
			return VideoDto.converter(videos);
		}
	}
}
