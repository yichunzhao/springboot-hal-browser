package com.ynz.haldemo;

import com.ynz.haldemo.domain.Author;
import com.ynz.haldemo.domain.Book;
import com.ynz.haldemo.repository.AuthorRepository;
import com.ynz.haldemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@SpringBootApplication
@RequiredArgsConstructor
public class HalDemoApplication implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(HalDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = Author.builder()
                .firstName("Eric")
                .lastName("Evans")
                .build();

        Book book1 = Book.builder()
                .authors(Stream.of(author1).collect(toSet()))
                .price(BigDecimal.valueOf(435.00))
                .title("Domain Driven Design")
                .build();

        author1.setBooks(Stream.of(book1).collect(toSet()));

        bookRepository.save(book1);
        authorRepository.save(author1);


    }
}
