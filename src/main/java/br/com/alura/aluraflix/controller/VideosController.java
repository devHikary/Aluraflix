package br.com.alura.aluraflix.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.aluraflix.modelo.Video;

@Controller
public class VideosController {
	
	@RequestMapping("/video")
	@ResponseBody
	public List<Video> lista() {
		Video video = new Video("video 1", "descricao", "url");
		
		return Arrays.asList(video, video);
	}
}
