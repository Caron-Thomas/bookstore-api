package com.br.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.bookstore.service.DBService;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	DBService dbservce;;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		dbservce.instanciaBaseDados();
		
	}

}
