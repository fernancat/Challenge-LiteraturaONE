package com.fernan.gt.Literature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernan.gt.Literature.principal.Principal;
import com.fernan.gt.Literature.repository.AuthorsRepository;
import com.fernan.gt.Literature.repository.BookRepository;

@SpringBootApplication
public class LiteratureApplication implements CommandLineRunner  {

	@Autowired
	BookRepository repositoryBook;

	@Autowired
	AuthorsRepository authorsRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteratureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositoryBook, authorsRepository);
		principal.Init();
	

	}

}
