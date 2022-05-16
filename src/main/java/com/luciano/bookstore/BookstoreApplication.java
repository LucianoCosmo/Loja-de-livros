package com.luciano.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luciano.bookstore.domain.Book;
import com.luciano.bookstore.domain.Category;
import com.luciano.bookstore.repositories.BookRepository;
import com.luciano.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat01 = new Category(null, "Informática", "Livros de Tecnologia da Informação");

		Book bk01 = new Book(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat01);
		
		cat01.getBooks().addAll(Arrays.asList(bk01));
	
		this.categoryRepository.saveAll(Arrays.asList(cat01));
		this.bookRepository.saveAll(Arrays.asList(bk01));
	}

}
