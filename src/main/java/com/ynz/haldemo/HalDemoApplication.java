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
import java.util.HashSet;

@SpringBootApplication
@RequiredArgsConstructor
public class HalDemoApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(HalDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = Author.builder()
                .firstName("Eric")
                .lastName("Evans")
                .books(new HashSet<>())
                .build();

        Book book1 = Book.builder()
                .price(BigDecimal.valueOf(435.00))
                .title("Domain Driven Design")
                .authors(new HashSet<>())
                .build();

        //associate book and author in bi-direction.
        book1.addAuthor(author1);

        bookRepository.save(book1);
    }
}
