package br.com.alura.aluraflix.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.aluraflix.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNome(String nome);
}
