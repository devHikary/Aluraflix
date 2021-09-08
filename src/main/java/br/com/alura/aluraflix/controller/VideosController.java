package br.com.alura.aluraflix.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.aluraflix.controller.dto.VideoDto;
import br.com.alura.aluraflix.modelo.Video;

@RestController
public class VideosController {
	
	@RequestMapping("/video")
	public List<VideoDto> lista() {
		Video video = new Video("video 1", "descricao", "url");
		
		return VideoDto.converter(Arrays.asList(video, video));
	}
}
