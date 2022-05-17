package com.luciano.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luciano.bookstore.services.DbService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	DbService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;	
	
	@Bean
	public boolean InstanciaDatabase() {
		if(strategy.equals("create")) {
			this.dbservice.InstanciaDatabase();
		}
		
		return false;
	}
}
