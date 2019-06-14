package com.isaquegarcia.aula01;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaquegarcia.aula01.domain.Categoria;
import com.isaquegarcia.aula01.repositories.CategoriaRepository;

@SpringBootApplication
public class Aula01Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		repo.saveAll(Arrays.asList(cat1,cat2));
	}

}
