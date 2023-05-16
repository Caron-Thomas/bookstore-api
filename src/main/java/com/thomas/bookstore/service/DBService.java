package com.thomas.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.bookstore.domain.Categoria;
import com.thomas.bookstore.domain.Livro;
import com.thomas.bookstore.repositories.CategoriaRepository;
import com.thomas.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() 
	{
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Romance", "Livros de ficção");
		Categoria cat3 = new Categoria(null, "Auto-ajuda", "Livros de auto-ajuda"); 
		
		Livro 	  l1   = new Livro(null, "Clean Code"		   , "Robert Martin"        , "Loren Ipsum", cat1);
		Livro 	  l2   = new Livro(null, "Café com Deus pai"   , "Junior Rostirola"     , "Loren Ipsum", cat3);
		Livro 	  l3   = new Livro(null, "É assim que acaba"   , "Colleen Hoover"       , "Loren Ipsum", cat3);
		Livro 	  l4   = new Livro(null, "Napoleon Hill"	   , "Citade Martin"        , "Loren Ipsum", cat3);
		Livro 	  l5   = new Livro(null, "A mandíbula de Caim" , "Edward Powys Mathers" , "Loren Ipsum", cat2);
		Livro 	  l6   = new Livro(null, "Onde estão as flores", "Ilko Minev"           , "Loren Ipsum", cat3);
		Livro 	  l7   = new Livro(null, "O Código Da Vinci"   , "Dan Brown"		    , "Loren Ipsum", cat2);
		Livro 	  l8   = new Livro(null, "O Alquimista"		   , "Paulo Coelho"			, "Loren Ipsum", cat2);
		Livro 	  l9   = new Livro(null, "Clean Architecture"  , "Robert Martin"		, "Loren Ipsum", cat1);
		Livro 	  l10  = new Livro(null, "Pai Rico Pai Pobre"  , " Robert Kiyosaki"  	, "Loren Ipsum", cat3);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1, l9));
		cat2.getLivros().addAll(Arrays.asList(l5, l7, l8));
		cat3.getLivros().addAll(Arrays.asList(l2, l3, l4, l6, l10));
		
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository    .saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10));
	}

}
