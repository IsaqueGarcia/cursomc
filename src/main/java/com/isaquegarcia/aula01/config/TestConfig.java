package com.isaquegarcia.aula01.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.isaquegarcia.aula01.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException { //Responsavel por instanciar meu profile no banco de teste
		dbService.instantiateTestDatabase();
		return true;
	}
}
