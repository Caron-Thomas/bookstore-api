package com.thomas.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thomas.bookstore.domain.Categoria;
import com.thomas.bookstore.domain.Livro;
import com.thomas.bookstore.repositories.CategoriaRepository;
import com.thomas.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Livro 	  l1   = new Livro(null,"Clean Code", "Robert Martin", "Loren Ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository    .saveAll(Arrays.asList(l1));
	}

}
