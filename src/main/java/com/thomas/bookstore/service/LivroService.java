package com.thomas.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.bookstore.domain.Categoria;
import com.thomas.bookstore.domain.Livro;
import com.thomas.bookstore.repositories.LivroRepository;
import com.thomas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer idCat) {
		categoriaService.findById(idCat);
		return livroRepository.findAllByCategoria(idCat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		if(obj.getTitulo() != null) 
				newObj.setTitulo(obj.getTitulo());

		if(obj.getNomeAutor() != null)
				newObj.setNomeAutor(obj.getNomeAutor());
		
		if(obj.getTexto() != null)
				newObj.setTexto(obj.getTexto());
	}

	public Livro create(Integer idCat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(idCat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		livroRepository.deleteById(id);
	}
	
}
