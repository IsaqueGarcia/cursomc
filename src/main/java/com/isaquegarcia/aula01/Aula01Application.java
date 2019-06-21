package com.isaquegarcia.aula01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaquegarcia.aula01.domain.Categoria;
import com.isaquegarcia.aula01.domain.Cidade;
import com.isaquegarcia.aula01.domain.Estado;
import com.isaquegarcia.aula01.domain.Produto;
import com.isaquegarcia.aula01.repositories.CategoriaRepository;
import com.isaquegarcia.aula01.repositories.CidadeRepositoy;
import com.isaquegarcia.aula01.repositories.EstadoRepositoy;
import com.isaquegarcia.aula01.repositories.ProdutoRepository;

@SpringBootApplication
public class Aula01Application implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository produtorepo;
	
	@Autowired
	private EstadoRepositoy estadoRepository;
	
	@Autowired
	private CidadeRepositoy cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		repo.saveAll(Arrays.asList(cat1,cat2));
		produtorepo.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
