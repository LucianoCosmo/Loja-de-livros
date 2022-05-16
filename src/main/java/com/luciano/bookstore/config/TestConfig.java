package com.luciano.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luciano.bookstore.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DbService dbservice;
	
	@Bean
	public void InstanciaDatabase() {
		this.dbservice.InstanciaDatabase();
	}
}
