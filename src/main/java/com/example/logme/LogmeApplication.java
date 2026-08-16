package com.example.logme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@SpringBootApplication
public class LogmeApplication implements CommandLineRunner{

	private final BookRepository bookRepository;
	private final ObjectMapper objectMapper;

	public LogmeApplication(
        BookRepository bookRepository,
        ObjectMapper objectMapper) {
    this.bookRepository = bookRepository;
    this.objectMapper = objectMapper;
}

	public static void main(String[] args) {
		SpringApplication.run(LogmeApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	if (bookRepository.count() == 0) {
		byte[] jsonData = Files.readAllBytes(Path.of("books_backup.json"));
        List<Book> books = objectMapper.readValue(
           jsonData,
           new TypeReference<List<Book>>() {}
        );
		bookRepository.saveAll(books);
	}
}

}
