package br.com.alura.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.aluraflix.modelo.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

}
