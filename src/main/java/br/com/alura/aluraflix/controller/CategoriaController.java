package br.com.alura.aluraflix.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.aluraflix.controller.dto.CategoriaDto;
import br.com.alura.aluraflix.controller.form.AtualizacaoCategoriaForm;
import br.com.alura.aluraflix.controller.form.CategoriaForm;
import br.com.alura.aluraflix.modelo.Categoria;
import br.com.alura.aluraflix.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaDto> lista(String nome) {
		List<Categoria> categorias = categoriaRepository.findAll();
		return CategoriaDto.converter(categorias);		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder) {
		Categoria categoria = form.converter();
		categoriaRepository.save(categoria);
		
		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> detalhar(@PathVariable Long id) {
		Optional<Categoria> optional = categoriaRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new CategoriaDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCategoriaForm form){
		Optional<Categoria> optional = categoriaRepository.findById(id);
		if(optional.isPresent()) {
			Categoria categoria = form.atualizar(id, categoriaRepository);
			return ResponseEntity.ok(new CategoriaDto(categoria));
		}
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Categoria> optional = categoriaRepository.findById(id);
		if(optional.isPresent()) {
			categoriaRepository.deleteById(id);		
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
