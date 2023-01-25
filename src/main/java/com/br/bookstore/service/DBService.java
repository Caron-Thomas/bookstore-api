package com.br.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.bookstore.domain.Categoria;
import com.br.bookstore.domain.Livro;
import com.br.bookstore.repositories.CategoriaRepository;
import com.br.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI"					);
		Categoria cat2 = new Categoria(null, "Romance"    , "Livros de ficção"				);
		Categoria cat3 = new Categoria(null, "História"	  , "Livros didáticos de história"	);
		  
		Livro l1 = new Livro(null, "Clean Code" 		   , "Robert Martin"   , "Ipsum Lorean", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Gestner", "Lorem ipsum" , cat1);
		Livro l3 = new Livro(null, "É Assim Que Acaba"	   , "Colleen Hoover"  , "Lorem ipsum" , cat2);
		Livro l4 = new Livro(null, "Nas Pegadas do Alemoa" , "Ilko Minev"      , "Lorem ipsum" , cat2);
		Livro l5 = new Livro(null, "Amor & Gelato"		   , "Jenn Evans Welch", "Lorem ipsum" , cat2);
		
		
		cat1.getLivros().addAll(Arrays.asList( l1, l2	 ));
		cat2.getLivros().addAll(Arrays.asList( l3, l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
