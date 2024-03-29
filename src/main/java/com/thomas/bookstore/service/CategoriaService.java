package com.thomas.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.bookstore.domain.Categoria;
import com.thomas.bookstore.dtos.CategoriaDTO;
import com.thomas.bookstore.repositories.CategoriaRepository;
import com.thomas.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		if(objDTO.getNome() != null)	{	
				obj.setNome(objDTO.getNome()); }
		if (objDTO.getDescricao() != null) {
				obj.setDescricao(objDTO.getDescricao()); }
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch ( org.springframework.dao.DataIntegrityViolationException e) {
			throw new com.thomas.bookstore
							.service.exceptions
							.DataIntegrityViolationException("Classe não pode ser deletada! Possui livros associados.");
		}
		
	}
}
