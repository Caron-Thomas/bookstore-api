package com.thomas.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thomas.bookstore.domain.Livro;
import com.thomas.bookstore.dtos.LivroDTO;
import com.thomas.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById( @PathVariable Integer id ){
		Livro obj = livroService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0")
				Integer idCat){
		List<Livro> list = livroService.findAll(idCat);
		List<LivroDTO> listDTO = list.stream()
									.map(obj -> new LivroDTO(obj))
									.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj ){
		Livro newObj = livroService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj ){
		Livro newObj = livroService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer idCat,
			@RequestBody Livro obj) {
		Livro newObj = livroService.create(idCat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
