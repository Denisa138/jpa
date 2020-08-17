package com.hellokoding.jpa;


import com.hellokoding.jpa.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateOneToManyMysqlApplication implements CommandLineRunner {
	private final BookService bookService;

	public JpaHibernateOneToManyMysqlApplication(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void run(String... args) {
		bookService.create();
		bookService.read();
		bookService.delete();
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateOneToManyMysqlApplication.class, args);
	}

}
