package com.luciano.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciano.bookstore.domain.Book;
import com.luciano.bookstore.domain.Category;
import com.luciano.bookstore.repositories.BookRepository;
import com.luciano.bookstore.repositories.CategoryRepository;

@Service
public class DbService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;
	
	public void InstanciaDatabase() {
		
		Category cat01 = new Category(null, "Informática", "Livros de Tecnologia da Informação");
		Category cat02 = new Category(null, "Ficção Científica", "Livros de ficção científica");
		Category cat03 = new Category(null, "Biografias", "Livros biograficos");

		Book bk01 = new Book(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat01);
		Book bk02 = new Book(null, "Engenharia de Software", "Louis V", "Lorem Ipsum", cat01);
		Book bk03 = new Book(null, "The Time Machine", "H. G. Wells", "Lorem Ipsum", cat02);
		Book bk04 = new Book(null, "The War of the Worlds", "H. G. Wells", "Lorem Ipsum", cat02);
		Book bk05 = new Book(null, "I, Robot", "Isaac Asimov ", "Lorem Ipsum", cat02);
		
		cat01.getBooks().addAll(Arrays.asList(bk01,bk02));
		cat02.getBooks().addAll(Arrays.asList(bk03,bk04,bk05));
	
		this.categoryRepository.saveAll(Arrays.asList(cat01, cat02, cat03));
		this.bookRepository.saveAll(Arrays.asList(bk01, bk02, bk03,bk04, bk05));
	}

}
